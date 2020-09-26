package ru.isu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ru.isu.model.auxiliary.FormData;
import ru.isu.model.basic.Geozone;
import ru.isu.model.custom.CustomGeozone;
import ru.isu.model.custom.CustomService;
import ru.isu.model.custom.Executor;
import ru.isu.model.custom.OrderStatistics;
import ru.isu.repository.ExecutorRepository;

import java.util.*;

@Service("decisionService")
public class DecisionService {
    @Autowired
    private ExecutorRepository executorRepository;

    public List<Executor> getExecutorChain(FormData formData) {
        List<Executor> allService = executorRepository.findAll();
        List<List<Pair<Executor, Geozone>>> availableChains = getAvailableChains(formData, allService);
        if (formData.getTo().getName() == formData.getFrom().getName())
            getAvailable(formData, allService, availableChains);
        int maxPrice = 0, minPrice = 999999;
        double bestQuality = 0, leastQuality = 10;
        for (List<Pair<Executor, Geozone>> chain :
                availableChains) {
            int price = getPrice(chain, formData);
            if (maxPrice < price)
                maxPrice = price;
            if (minPrice > price)
                minPrice = price;
            double quality = getQuality(chain);
            if (bestQuality < quality)
                bestQuality = quality;
            if (leastQuality > quality)
                leastQuality = quality;
        }
        formData.setMaxExecutorPrice(maxPrice);
        formData.setMinExecutorPrice(minPrice);
        formData.setMaxQuality(bestQuality);
        formData.setMinQuality(leastQuality);
        Map<List<Pair<Executor, Geozone>>, Double> executorsMarks = new HashMap<>();
        for (List<Pair<Executor, Geozone>> chain :
                availableChains) {
            executorsMarks.put(chain, formData.getMark(chain));
        }
        Iterator iterator = executorsMarks.keySet().iterator();
        List<Executor> best = null;
        while (iterator.hasNext()) {
            if (best == null) {
                best = (List<Executor>) iterator.next();
                continue;
            }
            List<Executor> temp = (List<Executor>) iterator.next();
            if (executorsMarks.get(best) < executorsMarks.get(temp))
                best = temp;
        }
        return best;
    }

    private void getAvailable(FormData formData, List<Executor> executors,
                              List<List<Pair<Executor, Geozone>>> available) {
        for (Executor exec :
                executors) {
            if (isContainService(exec.getCustomServices(), formData)) {
                Pair<Executor, Geozone> pair = Pair.of(exec, formData.getFrom());
                List<Pair<Executor, Geozone>> temp = new ArrayList<>();
                temp.add(pair);
                available.add(temp);
            }
        }

    }

    private boolean isContainService(List<CustomService> customServices, FormData formData) {
        for (CustomService customService :
                customServices) {
            if (isGood(customService, formData))
                return true;
        }
        return false;
    }

    private List<List<Pair<Executor, Geozone>>> getAvailableChains(FormData formData, List<Executor> executors) {
        List<List<Pair<Executor, Geozone>>> chains = new ArrayList<>();
        for (Executor executor :
                executors) {
            for (CustomService customService :
                    executor.getCustomServices()) {
                if (isGood(customService, formData)) {
                    for (CustomGeozone customGeozone :
                            customService.getCustomGeozones()) {
                        for (Executor executor1 :
                                executors) {
                            for (CustomService cservice :
                                    executor1.getCustomServices()) {
                                if (isAdd(cservice, formData, customGeozone.getGeozone(), formData.getTo())) {
                                    List<Pair<Executor, Geozone>> chain = new ArrayList<>();
                                    chain.add(Pair.of(executor, formData.getFrom()));
                                    chain.add(Pair.of(executor1, customGeozone.getGeozone()));
                                    chains.add(chain);
                                }
                            }
                        }
                    }
                }
            }
        }
        return chains;
    }

    public static int getPrice(List<Pair<Executor, Geozone>> executors, FormData formData) {
        int price = 0;
        for (Pair<Executor,Geozone> pair :
                executors) {
            for (CustomService cservice :
                    pair.getFirst().getCustomServices()) {
                    if (formData.getService().getName() == cservice.getService().getName())
                for (CustomGeozone cgeo :
                        cservice.getCustomGeozones())
                    if(cgeo.getGeozone().getName() == pair.getSecond().getName())
                    price += cgeo.getServicePrice();
            }
        }
        return price;
    }

    public static double getQuality(List<Pair<Executor, Geozone>> chain) {
        double quality = 0;
        for (Pair<Executor, Geozone> pair:
             chain) {
            OrderStatistics orderStatistics = pair.getFirst().getStatistics().getOrderStatistics();
            quality += orderStatistics.getOrdersAssignedOverall()/10000;
            quality += orderStatistics.getOrdersCompleted()/5000;
            quality += 1 - (orderStatistics.getOrdersFailedToComplete() - orderStatistics.getOrdersCompleted());
        }
        return quality;
    }

    private boolean isGood(CustomService customService, FormData formData) {
        if (customService.getService().getName() == formData.getService().getName() &&
                customService.getMaxWeight() > formData.getWeight() &&
                customService.getMinWeight() < formData.getWeight()) {
            for (CustomGeozone customGeozone :
                    customService.getCustomGeozones()) {
                if (customGeozone.getGeozone().getName() == formData.getFrom().getName() &&
                        customGeozone.getServicePrice() <= formData.getMaxCustomerPrice())
                    return true;
            }
        }
        return false;
    }

    private boolean isAdd(CustomService customService, FormData formData,
                          Geozone geozoneFrom, Geozone geozoneTo) {
        boolean flagTo = false, flagFrom = false;
        if (customService.getService().getName() == formData.getService().getName() &&
                customService.getMaxWeight() > formData.getWeight() &&
                customService.getMinWeight() < formData.getWeight()) {
            for (CustomGeozone customGeozone :
                    customService.getCustomGeozones()) {
                boolean flag = customGeozone.getServicePrice() <= formData.getMaxCustomerPrice();
                if (customGeozone.getGeozone().getName() == geozoneFrom.getName() && flag)
                    flagFrom = true;
                if (customGeozone.getGeozone().getName() == geozoneTo.getName() && flag)
                    flagFrom = true;
                if (flagFrom && flagTo)
                    return true;
            }
        }
        return false;
    }
}

package ru.isu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isu.model.basic.Geozone;
import ru.isu.model.basic.ServiceType;
import ru.isu.model.basic.SupplementaryCondition;
import ru.isu.model.custom.CustomData;
import ru.isu.model.custom.Data;
import ru.isu.model.custom.Executor;
import ru.isu.model.custom.OrderChain;
import ru.isu.repository.*;

import java.util.List;

@Service("uploadService")
public class UploadService {
    @Autowired
    private GeozoneRepository geozoneRepository;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private SupplementaryConditionRepository supplementaryConditionRepository;
    @Autowired
    private ExecutorRepository executorRepository;
    @Autowired
    private OrderChainRepository orderChainRepository;

    public void uploadToDB(Data data) {
        loadGeozone(data.getGeozones());
        loadService(data.getServices());
        //loadServiceType(data.getServiceTypes());
        loadSupp(data.getSupplementaryConditions());
        loadExecutor(data.getContractors());
        loadOrderChain(data.getOrderChains());
    }

    private void loadGeozone(List<Geozone> geozones) {
        for (Geozone geozone: geozones) {
            geozoneRepository.saveAndFlush(geozone);
        }
    }
    private void loadServiceType(List<ServiceType> serviceTypes) {
        for (ServiceType serviceType: serviceTypes) {
            serviceTypeRepository.saveAndFlush(serviceType);
        }
    }
    private void loadService(List<ru.isu.model.basic.Service> services) {
        for (ru.isu.model.basic.Service service: services) {
            serviceRepository.saveAndFlush(service);
        }
    }
    private void loadSupp(List<SupplementaryCondition> supps) {
        for (SupplementaryCondition supp: supps) {
            supplementaryConditionRepository.saveAndFlush(supp);
        }
    }
    private void loadExecutor(List<Executor> executors) {
        for (Executor executor: executors) {
            executorRepository.saveAndFlush(executor);
        }
    }
    private void loadOrderChain(List<OrderChain> orderChains) {
        for (OrderChain orderChain: orderChains) {
            orderChainRepository.saveAndFlush(orderChain);
        }
    }
}

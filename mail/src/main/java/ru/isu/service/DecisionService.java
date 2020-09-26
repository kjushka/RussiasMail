package ru.isu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isu.model.auxiliary.FormData;
import ru.isu.model.custom.Executor;
import ru.isu.repository.ExecutorRepository;

import java.util.*;

@Service("decisionService")
public class DecisionService {
    @Autowired
    private ExecutorRepository executorRepository;

    public List<Executor> getExecutorChain(FormData formData) {
        List<Executor> available = executorRepository.findExecutorsByParams();
        List<List<Executor>> availableChains = getAvailableChains(formData);
        Map<Object, Double> executorsMarks = new HashMap<>();
        for (Executor executor:
             available) {
            executorsMarks.put(executor, formData.getMark(executor));
        }
        for (List<Executor> executors:
                availableChains) {
            executorsMarks.put(executors, formData.getMark(executors));
        }
        Iterator iterator = executorsMarks.keySet().iterator();
        Object best = null;
        while (iterator.hasNext()) {
            if (best == null) {
                best = iterator.next();
                continue;
            }
            Object temp = iterator.next();
            if (executorsMarks.get(best) < executorsMarks.get(temp))
                best = temp;
        }
        if (available.contains(best))
            return (List<Executor>) best;
        List<Executor> bestExecutors = new ArrayList<>();
        bestExecutors.add((Executor) best);
        return bestExecutors;
    }

    private List<List<Executor>> getAvailableChains(FormData formData) {
        return null;
    }
}

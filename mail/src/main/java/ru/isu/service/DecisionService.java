package ru.isu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isu.repository.ExecutorRepository;

@Service("decisionService")
public class DecisionService {
    @Autowired
    private ExecutorRepository executorRepository;


}

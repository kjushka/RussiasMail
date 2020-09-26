package ru.isu.model.custom;

import lombok.Getter;
import lombok.Setter;
import ru.isu.model.basic.Geozone;
import ru.isu.model.basic.Service;
import ru.isu.model.basic.ServiceType;
import ru.isu.model.basic.SupplementaryCondition;

import java.util.List;

@Setter
@Getter
public class Data {
    private List<Geozone> geozones;
    private List<ServiceType> serviceTypes;
    private List<Service> services;
    private List<SupplementaryCondition> supplementaryConditions;
    private List<Executor> contractors;
    private List<OrderChain> orderChains;
}

package ru.isu.model.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.isu.model.basic.Geozone;
import ru.isu.model.basic.Service;
import ru.isu.model.basic.ServiceType;
import ru.isu.model.basic.SupplementaryCondition;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Data {
    private List<Geozone> geozones;
    private List<ServiceType> serviceTypes;
    private List<Service> services;
    private List<SupplementaryCondition> supplementaryConditions;
    private List<Executor> contractors;
    private List<OrderChain> orderChains;

    @Override
    public String toString() {
        return "Data{" +
                "geozones=" + geozones +
                ", serviceTypes=" + serviceTypes +
                ", services=" + services +
                ", supplementaryConditions=" + supplementaryConditions +
                ", contractors=" + contractors +
                ", orderChains=" + orderChains +
                '}';
    }
}

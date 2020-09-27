package ru.isu.model.auxiliary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;
import ru.isu.model.basic.Geozone;
import ru.isu.model.basic.Service;
import ru.isu.model.custom.Executor;
import ru.isu.service.DecisionService;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FormData {
    private Service service;
    private Geozone from;
    private Geozone to;
    private int weight;
    private int maxCustomerPrice;
    private int maxExecutorPrice;
    private int minExecutorPrice;
    private double maxQuality;
    private double minQuality;
    private byte priority;

    public double getMark(List<Pair<Executor, Geozone>> executors) {
        double mark = 0;
        double priceMark = DecisionService.getPrice(executors, this) / (maxExecutorPrice - minExecutorPrice);
        double qualityMark = DecisionService.getQuality(executors) / (maxQuality - minQuality);
        switch (priority) {
            case -1:
                mark += priceMark * 4 + qualityMark;
            case 1:
                mark += priceMark + qualityMark * 4;
            default:
                mark += priceMark * 2 + qualityMark * 2;
        }
        return mark;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "service=" + service +
                ", from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                ", maxCustomerPrice=" + maxCustomerPrice +
                ", maxExecutorPrice=" + maxExecutorPrice +
                ", minExecutorPrice=" + minExecutorPrice +
                ", maxQuality=" + maxQuality +
                ", minQuality=" + minQuality +
                ", priority=" + priority +
                '}';
    }
}

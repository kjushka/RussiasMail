package ru.isu.model.auxiliary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.isu.model.basic.Geozone;
import ru.isu.model.basic.Service;
import ru.isu.model.custom.Executor;

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

    public double getMark(Executor executor) {
        double mark = 0;
        switch (priority) {
            case -1:
            case 0:
            case 1:
            default:
        }
        return mark;
    }

    public double getMark(List<Executor> executors) {
        double mark = 0;
        switch (priority) {
            case -1:
            case 0:
            case 1:
            default:
        }
        return mark;
    }
}

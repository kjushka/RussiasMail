package Taezhnik;

import java.util.Arrays;

class Statistics{
    Order_statistics order_statistics;

    @Override
    public String toString() {
        return "Statistics{" +
                "order_statistics=" + order_statistics +
                '}';
    }
}

public class Contractors {
    String id;
    String name;
    Services [] services;
    Supplementary_conditions [] supplementary_conditions;
    Geozones [] geozones;
    Statistics statistics;
    int min_weight;
    int max_weight;

    @Override
    public String toString() {
        return "Contractors{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", services=" + Arrays.toString(services) +
                ", supplementary_conditions=" + Arrays.toString(supplementary_conditions) +
                ", geozones=" + Arrays.toString(geozones) +
                ", statistics=" + statistics +
                ", min_weight=" + min_weight +
                ", max_weight=" + max_weight +
                '}';
    }
}

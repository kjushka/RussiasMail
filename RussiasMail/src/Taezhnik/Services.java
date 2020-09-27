package Taezhnik;

import java.util.Arrays;

class Service_type {
    String id;
    String name;

    @Override
    public String toString() {
        return "Service_type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Services {
    String id;
    String name;
    String description;
    Service_type service_type;
    Supplementary_conditions [] supplementary_conditions;
    Geozones [] geozones;
    int min_weight;
    int max_weight;

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", service_type=" + service_type +
                ", supplementary_conditions=" + Arrays.toString(supplementary_conditions) +
                ", geozones=" + Arrays.toString(geozones) +
                ", min_weight=" + min_weight +
                ", max_weight=" + max_weight +
                '}';
    }
}

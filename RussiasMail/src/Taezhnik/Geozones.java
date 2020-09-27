package Taezhnik;

import com.google.gson.annotations.SerializedName;

public class Geozones {
    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    public int service_price;
    public int average_execution_time;
    public String provided_from;
    public String provided_to;


    public Geozones(String _id, String _name){
        this.id = _id;
        this.name = _name;
    }

    @Override
    public String toString() {
        return "Geozones{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", service_price=" + service_price +
                ", average_execution_time=" + average_execution_time +
                ", provided_from='" + provided_from + '\'' +
                ", provided_to='" + provided_to + '\'' +
                '}';
    }

    //int service_price;
    //int average_execution_time;
    //String provided_from;
    //String provided_to;
}

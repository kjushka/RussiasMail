package ru.isu.model.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomData {
    private Data data;

    @Override
    public String toString() {
        return "CustomData{" +
                "data=" + data +
                '}';
    }
}

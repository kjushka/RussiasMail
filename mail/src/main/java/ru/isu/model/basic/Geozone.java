package ru.isu.model.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "geozone")
public class Geozone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "Geozone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

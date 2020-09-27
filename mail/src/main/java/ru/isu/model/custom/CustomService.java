package ru.isu.model.custom;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ru.isu.model.basic.Service;
import ru.isu.model.basic.SupplementaryCondition;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CustomService {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            foreignKey = @ForeignKey(name = "service_id")
    )
    private Service service;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "cservice_supp",
            joinColumns = @JoinColumn(name = "cservice_id"),
            inverseJoinColumns = @JoinColumn(name = "supp_id")
    )
    private List<SupplementaryCondition> supplementaryConditions;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "cservice_cgeozone",
            joinColumns = @JoinColumn(name = "cservice_id"),
            inverseJoinColumns = @JoinColumn(name = "cgeozone_id")
    )
    private List<CustomGeozone> customGeozones;
    private Integer minWeight;
    private Integer maxWeight;
}

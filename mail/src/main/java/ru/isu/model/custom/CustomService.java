package ru.isu.model.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.isu.model.Service;
import ru.isu.model.SupplementaryCondition;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private Set<SupplementaryCondition> supplementaryConditions;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "cservice_cgeozone",
            joinColumns = @JoinColumn(name = "cservice_id"),
            inverseJoinColumns = @JoinColumn(name = "cgeozone_id")
    )
    private Set<CustomGeozone> customGeozones;
    private Integer minWeight;
    private Integer maxWeight;
}

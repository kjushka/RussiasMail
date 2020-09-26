package ru.isu.model.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Executor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "executor_services",
            joinColumns = @JoinColumn(name = "executor_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<CustomService> customServices;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            foreignKey = @ForeignKey(name = "statistics_id")
    )
    private Statistics statistics;
}


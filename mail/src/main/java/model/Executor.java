package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
=======
import model.custom.CustomService;
>>>>>>> origin/master

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Executor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Long id;
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
<<<<<<< HEAD
    private Set<Service> services;

}
=======
    private Set<CustomService> customServices;

}
>>>>>>> origin/master

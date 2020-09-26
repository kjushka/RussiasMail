package ru.isu.model.basic;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "supp_cond")
public class SupplementaryCondition {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
}


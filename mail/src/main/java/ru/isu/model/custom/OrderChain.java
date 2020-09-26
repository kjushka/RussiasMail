package ru.isu.model.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderChain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "chain_corders",
            joinColumns = @JoinColumn(name = "chain_id"),
            inverseJoinColumns = @JoinColumn(name = "corder_id")
    )
    private List<CustomOrder> orders;
}

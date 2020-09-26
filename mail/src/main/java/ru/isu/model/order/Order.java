package ru.isu.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.isu.model.basic.Service;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Service service;
}

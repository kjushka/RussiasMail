package ru.isu.model.custom;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.isu.model.basic.Geozone;
import ru.isu.model.basic.SupplementaryCondition;
import ru.isu.model.order.Order;
import ru.isu.model.order.OrderData;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CustomOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer index;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            foreignKey = @ForeignKey(name = "order_id")
    )
    private Order order;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            foreignKey = @ForeignKey(name = "odata_id")
    )
    private OrderData orderData;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<SupplementaryCondition> supplementaryConditions;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            foreignKey = @ForeignKey(name = "geozone_id")
    )
    private Geozone geozone;
}

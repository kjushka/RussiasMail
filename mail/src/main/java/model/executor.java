package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "executors")
/* Базовый класс исполнителя*/
public class executor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "timeSlots")
    private String timeSlots;
    @Column(name = "deliveryTime")
    private Integer dTime;
    @Column(name = "capacity")
    private Integer capacity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryType_id", referencedColumnName = "id")
    private TypeDelivery typeD;
    @OneToMany(mappedBy="cart")
    private Set<AdditionalOption> items;
}

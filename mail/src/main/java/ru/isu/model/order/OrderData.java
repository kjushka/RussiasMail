package ru.isu.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer weight;
    @OneToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "timeslot_id")
    )
    private Timeslot timeslot;
}

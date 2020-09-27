package ru.isu.model.order;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor
public class OrderData {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private Integer weight;
    @OneToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "timeslot_id")
    )
    private Timeslot timeslot;
}

package ru.isu.model.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            foreignKey = @ForeignKey(name = "order_statistics_id")
    )
    private OrderStatistics orderStatistics;
}

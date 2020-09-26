package ru.isu.model.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer ordersAssignedOverall;
    private Integer ordersCompleted;
    private Integer ordersCancelled;
    private Integer ordersCancelledByClient;
    private Integer ordersFailedToComplete;
}

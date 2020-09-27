package ru.isu.model.custom;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor
public class OrderStatistics {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private Integer ordersAssignedOverall;
    private Integer ordersCompleted;
    private Integer ordersCancelled;
    private Integer ordersCancelledByClient;
    private Integer ordersFailedToComplete;
}

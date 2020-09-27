package ru.isu.model.custom;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ru.isu.model.basic.Geozone;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CustomGeozone {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            foreignKey = @ForeignKey(name = "geozone_id")
    )
    private Geozone geozone;
    private Integer servicePrice;
    private Integer averageExecutionTime;
    private String providedFrom;
    private String providedTo;
}

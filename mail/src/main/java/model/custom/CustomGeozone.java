package model.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Geozone;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomGeozone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
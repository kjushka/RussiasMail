package ru.isu.model.custom;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor
public class OrderChain {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "chain_corders",
            joinColumns = @JoinColumn(name = "chain_id"),
            inverseJoinColumns = @JoinColumn(name = "corder_id")
    )
    private List<CustomOrder> orders;
}

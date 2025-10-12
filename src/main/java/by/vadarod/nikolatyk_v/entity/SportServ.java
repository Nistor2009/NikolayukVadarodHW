package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "service", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class SportServ {
    @Id
    @SequenceGenerator(name = "serviceSequence", sequenceName = "s_service", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviceSequence")
    private Long id;
    @Column(length = 1000)
    private String name;
    private double price;
    @OneToMany
    @JoinColumn(name = "building_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Building> buildings;
}

package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "building", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Building {
    @Id
    @SequenceGenerator(name = "buildingSequence", sequenceName = "s_building", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buildingSequence")
    private Long id;
    @Column(length = 1000)
    private String name;
    @Column(name = "ident_number")
    private String identNumber;
    @Column(name = "max_people_count")
    private int maxPeopleCount;
    private String status;
    @Column(name = "price_per_hour")
    private double pricePerHour;

    public Building(Long id, String name, String identNumber, int maxPeopleCount, String status, double pricePerHour){
        this.id = id;
        this.name = name;
        this.identNumber = identNumber;
        this.maxPeopleCount = maxPeopleCount;
        this.status = status;
        this.pricePerHour = pricePerHour;
    }
}

package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "service", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class SportServ {
    @Id
    @SequenceGenerator(name = "serviceSequence", sequenceName = "s_service", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviceSequence")
    private Long id;
    @Column(length = 1000)
    private String name;
    private double price;

    public SportServ(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

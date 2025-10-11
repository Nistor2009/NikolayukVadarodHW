package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Table(name = "small_building", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@Immutable
@Subselect("select p.id as id" +
        ", p.ident_number as identNumber" +
        ", p.price_per_hour as pricePerHour " +
        "from work.building p where p.max_people_count<=15")
public class SmallBuilding {
    @Id
    private Long id;
    private String identNumber;
    private double pricePerHour;

}

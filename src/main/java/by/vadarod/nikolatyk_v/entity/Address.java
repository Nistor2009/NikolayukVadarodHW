package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "address", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Address {
    //город, улица, номер дома, почтовый индекс
//    @Id
//    @SequenceGenerator(name = "addressSequence", sequenceName = "s_address", allocationSize = 1, schema = "work")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressSequence")
    private String city;
    private String street;
    private String house;
    @Column(name = "post_index")
    private String postIndex;
}

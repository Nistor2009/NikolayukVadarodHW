package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Address {
    //город, улица, номер дома, почтовый индекс
    private String city;
    private String street;
    private String house;
    @Column(name = "post_index")
    private String postIndex;
}

package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "client", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Client {
    @Id
    @SequenceGenerator(name = "clientSequence", sequenceName = "s_client", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientSequence")
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    @Embedded
    private Address address;
}


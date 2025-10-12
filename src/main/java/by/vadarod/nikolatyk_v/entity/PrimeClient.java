package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.Calendar;

@Entity
@Table(name = "prime_client", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Where(clause = "status = 'PRIME'")
public class PrimeClient {
    @Id
    @SequenceGenerator(name = "primeClientSequence", sequenceName = "s_prime_client", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primeClientSequence")
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    @Column(name = "last_visit")
    private Calendar lastVisit;
    private String status;
    @Column(name = "spent_money")
    private double spentMoney;
    @Embedded
    private Address address;

    @Override
    public String toString() {
        return "Client(id = "+id+", name = "+name+", surname = "+surname+", status = "+status+")";
    }
}
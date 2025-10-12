package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "visit", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Visit {
    @Id
    @SequenceGenerator(name = "visitSequence", sequenceName = "s_visit", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visitSequence")
    private Long id;
    @Column(name = "visit_date")
    private LocalDate visitDate;
    @Column(name = "spent_money")
    private BigDecimal spentMoney;
}

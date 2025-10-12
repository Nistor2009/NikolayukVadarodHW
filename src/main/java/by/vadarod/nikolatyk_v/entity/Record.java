package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "record", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Record {
    @Id
    @SequenceGenerator(name = "recordSequence", sequenceName = "s_record", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recordSequence")
    private Long id;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "building_id")
    private Long buildingId;
    private LocalDate date;
    private LocalTime time;
}

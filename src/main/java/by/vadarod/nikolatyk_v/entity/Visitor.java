package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "visitor", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@PrimaryKeyJoinColumn(name = "client_id")
public class Visitor extends Client{
    private String status;
    @Column(name = "last_visit")
    private Calendar lastVisit;
    @Column(name = "spent_money")
    private double spentMoney;
    @Column(name = "first_visit")
    private Calendar firstVisit;
    @OneToMany
    @JoinColumn(name = "visits_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Visit> visits;
    @OneToMany
    @JoinColumn(name = "client_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Record> records;
}

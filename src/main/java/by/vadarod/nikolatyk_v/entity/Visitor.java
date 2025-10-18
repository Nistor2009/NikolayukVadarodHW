package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "visitor", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "client_id")
public class Visitor extends Client{
    private String status;
    @Column(name = "last_visit")
    @ToString.Exclude
    private Calendar lastVisit;
    @Column(name = "spent_money")
    private double spentMoney;
    @Column(name = "first_visit")
    @ToString.Exclude
    private Calendar firstVisit;
    @OneToMany
    @JoinColumn(name = "visits_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Visit> visits = new ArrayList<>();
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER) //потестировал n+1. Посмотри VisitorRepositoryImpl
    @JoinColumn(name = "client_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Record> records = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }
}

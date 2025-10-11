package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "visitor", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "client_id")
public class Visitor extends Client{
    private String status;
    @Column(name = "last_visit")
    private Calendar lastVisit;
    @Column(name = "spent_money")
    private double spentMoney;
    @Column(name = "first_visit")
    private Calendar firstVisit;
}

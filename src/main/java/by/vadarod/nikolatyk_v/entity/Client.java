package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "client", schema = "work")
@Data
@NoArgsConstructor
@Setter
public class Client {
    @Id
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    @Column(name = "last_visit")
    private Calendar lastVisit;
    private String state;
    @Column(name = "spent_money")
    private double spentMoney;

    public Client(Long id, String name, String surname, int age, String phone, Calendar lastVisit, String state, double spentMoney){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.lastVisit = lastVisit;
        this.state = state;
        this.spentMoney = spentMoney;
    }
}


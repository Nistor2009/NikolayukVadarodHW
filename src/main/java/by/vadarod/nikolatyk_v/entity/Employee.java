package by.vadarod.nikolatyk_v.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "employee", schema = "work")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "client_id")
public class Employee extends Client{
    @Column(name = "arrangement_date")
    @ToString.Exclude
    private Calendar arrangementDate;
    @Column(name = "quit_date")
    private Calendar quitDate;
    @Column(name = "job_position")
    private String jobPosition;
    private double salary;

    @Override
    public String toString() {
        String s = super.toString() ;
        return s + " " + salary + " " + jobPosition;
    }
}

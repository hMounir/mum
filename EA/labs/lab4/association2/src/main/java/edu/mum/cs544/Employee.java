package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    private Office office;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + Optional.ofNullable(department.getName()).orElse(null) +
                ", office=" + Optional.ofNullable(office.getName()).orElse(null) +
                '}';
    }
}

package edu.mum.cs544.bidirectional;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Laptop> laptops = new HashSet<>();

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Set<Laptop> laptops) {
        this.name = name;
        this.laptops = laptops;
    }

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
        laptop.setEmployee(this);
    }

    public void removeLaptop(Laptop laptop) {
        laptops.remove(laptop);
        laptop.setEmployee(null);
    }
}
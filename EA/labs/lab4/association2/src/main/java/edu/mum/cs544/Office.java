package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Office(String name) {
        this.name = name;
    }

    public boolean addEmployee(Employee employee) {
        if (employees.add(employee)) {
            employee.setOffice(this);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(Employee employee) {
        if (employees.remove(employee)) {
            employee.setOffice(null);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees.stream().map(Employee::getName).collect(Collectors.toList()) +
                '}';
    }
}

package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public boolean addOrder(Order order) {
        if (orders.add(order)) {
            order.setCustomer(this);
            return true;
        }
        return false;
    }

    public boolean removeOrder(Order order) {
        if (orders.remove(order)) {
            order.setCustomer(null);
            return true;
        }
        return false;
    }
}

package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.uuid.CustomVersionOneStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue
    private Integer orderid;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order(Date date) {
        this.date = date;
    }

    public boolean addOrderLine(OrderLine orderLine) {
        if (orderLines.add(orderLine)) {
            return true;
        }
        return false;
    }

    public boolean removeOrderLine(OrderLine orderLine) {
        if (orderLines.remove(orderLine)) {
            return true;
        }
        return false;
    }
}

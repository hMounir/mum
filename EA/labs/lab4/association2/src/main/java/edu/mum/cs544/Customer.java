package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public boolean addReservation(Reservation reservation) {
        if (reservations.add(reservation)) {
            return true;
        }
        return false;
    }

    public boolean removeReservation(Reservation reservation) {
        if (reservations.remove(reservation)) {
            return true;
        }
        return false;
    }
}

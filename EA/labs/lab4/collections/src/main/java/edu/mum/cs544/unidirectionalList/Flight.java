package edu.mum.cs544.unidirectionalList;

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
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "flightId")
    private List<Passenger> passengers = new ArrayList<>();

    public Flight(String name) {
        this.name = name;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}

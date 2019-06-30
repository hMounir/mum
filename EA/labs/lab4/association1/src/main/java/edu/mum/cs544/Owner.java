package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "owner")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

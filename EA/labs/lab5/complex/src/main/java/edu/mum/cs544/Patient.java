package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "Address", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "patient_id", referencedColumnName = "id")
})
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(table = "Address")
    private String street;
    @Column(table = "Address")
    private String zip;
    @Column(table = "Address")
    private String city;


    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}

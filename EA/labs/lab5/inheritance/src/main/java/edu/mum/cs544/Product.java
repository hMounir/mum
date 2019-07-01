package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Setter
@Getter
public abstract class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;


    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

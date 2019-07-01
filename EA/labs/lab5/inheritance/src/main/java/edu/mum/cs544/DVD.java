package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class DVD extends Product {

    private String genre;

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }
}

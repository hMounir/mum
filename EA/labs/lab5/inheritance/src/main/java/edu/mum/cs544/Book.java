package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Book extends Product {

    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }
}

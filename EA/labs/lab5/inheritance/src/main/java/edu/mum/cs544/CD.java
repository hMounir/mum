package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class CD extends Product {

    private String artist;


    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }
}

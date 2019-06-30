package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Publisher {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Publisher(String name) {
        this.name = name;
    }
}

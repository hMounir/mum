package edu.mum.cs544.unidirectionalMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Student {

    @Id
    private int id;

    @Column
    private String name;

    public Student(String name) {
        this.name = name;
    }
}

package edu.mum.cs544.unidirectionalMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private int id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "schoolId")
    private Map<Integer,Student> students = new HashMap<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Integer id,Student student) {
        student.setId(id);
        students.put(id,student);
    }
}

package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Course {
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
  private List<Student> students = new ArrayList<>();


  public Course(String name) {
    this.name = name;
  }


  public boolean addStudent(Student student) {
    if (!this.students.contains(student)) {
      if (students.add(student)) {
        student.getCourses().add(this);
        return true;
      }
    }
    return false;
  }

  public boolean removeStudent(Student student) {
    if (students.remove(student)) {
      student.getCourses().remove(this);
      return true;
    }
    return false;
  }
}
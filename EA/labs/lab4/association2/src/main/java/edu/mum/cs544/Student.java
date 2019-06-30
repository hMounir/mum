package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Student {
  @Id
  private Integer studentId;
  private String name;
  private String email;
  private String password;
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Course> courses = new ArrayList<>();

  public Student(Integer id, String name, String email, String password) {
    this.studentId = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public boolean addCourse(Course course) {
    if (!this.courses.contains(course)) {
      if (courses.add(course)) {
        course.getStudents().add(this);
        return true;
      }
    }
    return false;
  }

  public boolean removeCourse(Course course) {
    if (courses.remove(course)) {
      course.getStudents().remove(this);
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Student{" +
            "studentId=" + studentId +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", courses=" + courses.stream().map(Course::getName).collect(Collectors.toList()) +
            '}';
  }
}
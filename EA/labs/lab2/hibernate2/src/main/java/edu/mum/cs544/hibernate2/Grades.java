package edu.mum.cs544.hibernate2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.*;
import javax.persistence.*;

@Entity
@Table(name = "grades")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grades {

  @Id
  @GeneratedValue
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"student_id\"", nullable = false)
  private Integer studentId;
  @Column(name = "\"course_id\"", nullable = false)
  private Integer courseId;
  @Column(name = "\"grade\"", nullable = true)
  private String grade;
}
package edu.mum.cs544.hibernate2;

import lombok.*;

import java.sql.*;
import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Students {

  @Id
  @GeneratedValue
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"name\"", nullable = true)
  private String name;
  @Column(name = "\"email\"", nullable = true)
  private String email;
  @Column(name = "\"password\"", nullable = true)
  private String password;

  public Students(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
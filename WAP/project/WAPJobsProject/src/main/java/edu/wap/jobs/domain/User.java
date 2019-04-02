package edu.wap.jobs.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "username")
    private String username;

    @Column(name = "createdDate")
    private Timestamp createdDate;

    @Column(name = "modifiedDate")
    private Timestamp modifiedDate;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.modifiedDate = new Timestamp(System.currentTimeMillis());
    }

}
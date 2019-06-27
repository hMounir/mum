package edu.mum.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID", nullable = false)
    private Long id = null;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean admin = false;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "lastlogin")
    private Date lastLogin;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "RATING", nullable = false)
    private int rating = 0;

    @Version
    @Column(name = "VERSION", nullable = false)
    private int version = 0;

    public User(boolean admin, String email, String firstName, Date lastLogin, String lastName, int rating, int version) {
        this.admin = admin;
        this.email = email;
        this.firstName = firstName;
        this.lastLogin = lastLogin;
        this.lastName = lastName;
        this.rating = rating;
        this.version = version;
    }
}
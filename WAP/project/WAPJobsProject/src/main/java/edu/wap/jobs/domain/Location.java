package edu.wap.jobs.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "location")
@Getter
@Setter
@EqualsAndHashCode
public class Location implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "street")
    private String street;

    @Basic
    @Column(name = "city")
    private String city;

    @Basic
    @Column(name = "state")
    private String state;
}

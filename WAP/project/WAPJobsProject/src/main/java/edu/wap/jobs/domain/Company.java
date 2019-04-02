package edu.wap.jobs.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@EqualsAndHashCode
public class Company {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;
}

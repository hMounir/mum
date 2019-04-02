package edu.wap.jobs.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "industry")
@Getter
@Setter
@EqualsAndHashCode
public class Industry implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;
}

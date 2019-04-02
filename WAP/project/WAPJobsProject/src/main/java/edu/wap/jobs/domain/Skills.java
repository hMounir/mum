package edu.wap.jobs.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "skills")
@Getter
@Setter
@EqualsAndHashCode
public class Skills implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;
}

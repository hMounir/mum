package edu.wap.jobs.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "state")
@Getter
@Setter
@EqualsAndHashCode
public class State implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "state")
    private String state;

    @Column(name = "abbrev")
    private String abreviation;
}

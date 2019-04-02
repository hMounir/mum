package edu.wap.jobs.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@EqualsAndHashCode
public class Jobs implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="titleId",referencedColumnName = "id")
    private JobTitle jobTitle;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="locationId")
    private Location location;

    @Column(name = "jobTypeId")
    private int jobTypeId;

    @ManyToOne
    @JoinColumn(name="industryId")
    private Industry industry;

    @ManyToOne
    @JoinColumn(name="companyId")
    private Company company;

    @Basic
    @Column(name = "createdDate")
    private Timestamp createdDate;

    @Basic
    @Column(name = "modifiedDate")
    private Timestamp modifiedDate;
}

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
@Table(name = "appliedJobs")
@Getter
@Setter
@EqualsAndHashCode

public class AppliedJobs implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "jobId")
    private int jobId;

    @Column(name = "userId")
    private int userId;

    public AppliedJobs(int jobId, int userId) {
        this.jobId = jobId;
        this.userId = userId;
    }
}

package edu.wap.jobs.dao;

import edu.wap.jobs.domain.AppliedJobs;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AppliedJobDao extends GenericDao<AppliedJobs> {

    public AppliedJobDao() {
        super(AppliedJobs.class);
    }



}

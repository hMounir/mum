package edu.wap.jobs.dao;

import edu.wap.jobs.domain.Company;
import edu.wap.jobs.domain.JobTitle;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class JobTitleDao extends GenericDao<JobTitle>{

    public JobTitleDao() {
        super(JobTitle.class);
    }

    public boolean nameExists(String name){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from jobTitle j where j.name = :name ");
        query.setParameter("name", name);
        List list = query.list();
        session.close();
        return list.isEmpty();
    }
}

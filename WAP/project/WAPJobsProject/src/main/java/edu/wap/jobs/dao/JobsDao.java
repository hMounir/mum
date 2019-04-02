package edu.wap.jobs.dao;

import edu.wap.jobs.domain.Company;
import edu.wap.jobs.domain.Jobs;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class JobsDao extends GenericDao<Jobs>{

    public JobsDao() {
        super(Jobs.class);
    }

    public List<Jobs> getPaginatedJobs(int rowNumber,int page){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From Jobs",Jobs.class);
        query.setFirstResult(rowNumber);
        query.setMaxResults(page);
        List<Jobs> jobsList = query.list();
        session.close();
        return jobsList;
    }
}

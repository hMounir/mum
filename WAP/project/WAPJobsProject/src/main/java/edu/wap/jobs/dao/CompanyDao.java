package edu.wap.jobs.dao;

import edu.wap.jobs.domain.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyDao extends GenericDao<Company>{

    public CompanyDao() {
        super(Company.class);
    }

    public boolean nameExists(String name){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from company j where j.name = :name ");
        query.setParameter("name", name);
        List list = query.list();
        session.close();
        return list.isEmpty();
    }


}

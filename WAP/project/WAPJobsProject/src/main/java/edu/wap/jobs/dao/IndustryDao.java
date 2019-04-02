package edu.wap.jobs.dao;

import edu.wap.jobs.domain.Industry;
import edu.wap.jobs.domain.Location;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class IndustryDao extends GenericDao<Industry>{

    public IndustryDao() {
        super(Industry.class);
    }

    public boolean nameExists(String name){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from industry j where j.name = :name ");
        query.setParameter("name", name);
        List list = query.list();
        session.close();
        return list.isEmpty();
    }
}

package edu.wap.jobs.dao;

import edu.wap.jobs.domain.Skills;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SkillsDao extends GenericDao<Skills>{

    public SkillsDao() {
        super(Skills.class);
    }

    public boolean nameExists(String name){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from skills j where j.name = :name ");
        query.setParameter("name", name);
        List list = query.list();
        session.close();
        return list.isEmpty();
    }
}

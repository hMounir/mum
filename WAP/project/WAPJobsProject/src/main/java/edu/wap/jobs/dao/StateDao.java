package edu.wap.jobs.dao;

import edu.wap.jobs.domain.State;
import edu.wap.jobs.domain.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Timestamp;
import java.util.List;

public class StateDao extends GenericDao<State> {

    public StateDao() {
        super(State.class);
    }

    public List<State> getStateList(){
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<State> cr = cb.createQuery(State.class);
        cr.select(cr.from(State.class));

        Query<State> query = session.createQuery(cr);
        List<State> results = query.getResultList();
        session.close();
        return results;
    }
}

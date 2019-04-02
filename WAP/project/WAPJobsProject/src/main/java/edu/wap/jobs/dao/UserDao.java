package edu.wap.jobs.dao;

import edu.wap.jobs.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao extends GenericDao<User>{

    public UserDao() {
        super(User.class);
    }

    public User validateUser(User user){
        Session session = this.sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        cr.select(cr.from(User.class))
                .where(
                        cb.equal(cr.from(User.class).get("email"), user.getEmail()),
                        cb.equal(cr.from(User.class).get("password"), user.getPassword())
                );

        Query<User> query = session.createQuery(cr);
        List<User> results = query.getResultList();
        session.close();
        return results.stream().findFirst().orElse(null);
    }
    public User isExistingUser(User user){
        Session session = this.sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        cr.select(cr.from(User.class))
                .where(
                        cb.equal(cr.from(User.class).get("email"), user.getEmail())
                );

        Query<User> query = session.createQuery(cr);
        List<User> results = query.getResultList();
        session.close();
        return results.stream().findFirst().orElse(null);
    }

    public User isExistingUser(String email){
        Session session = this.sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        cr.select(cr.from(User.class))
                .where(
                        cb.equal(cr.from(User.class).get("email"), email)
                );

        Query<User> query = session.createQuery(cr);
        List<User> results = query.getResultList();
        session.close();
        return results.stream().findFirst().orElse(null);
    }



}

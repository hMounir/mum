package edu.wap.jobs.dao;

import edu.wap.jobs.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class GenericDao<T> {

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public <T> T save(T o){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T t = (T) session.save(o);
        transaction.commit();
        session.close();
        return t;
    }

    public <T> void update(T o){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(o);
        transaction.commit();
        session.close();
    }

    public void delete(Serializable object){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T t = session.get(entityClass, object);
        session.delete(t);
        transaction.commit();
        session.close();
    }

    public <T> T get(Integer id){
        Session session = this.sessionFactory.openSession();
        T t = (T) session.get(entityClass, id);
        session.close();
        return t;
    }

    public <T> List<T> getAll() {
        Session session = this.sessionFactory.openSession();
        List<T> list = session.createCriteria(entityClass).list();
        session.close();
        return list;
    }

    public List<T> getLimitedesults() {
        Session session = this.sessionFactory.openSession();
        List<T> list = session.createCriteria(entityClass).setMaxResults(5).list();
        session.close();
        return list;
    }
}

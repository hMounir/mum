package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CustomerDAO implements ICustomerDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
		System.out.println("CustomerDAO: saving customer "+customer.getName());
	}

}

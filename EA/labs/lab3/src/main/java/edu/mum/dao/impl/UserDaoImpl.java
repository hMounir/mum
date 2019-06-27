package edu.mum.dao.impl;

 

import javax.persistence.Query;

import edu.mum.dao.GenericDao;
import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;


@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{
	

	public User findByEmail(String email) {
		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();
	}


	public void saveFlush(User entity) {
		super.save(entity);
		entityManager.flush();
	}

	public void refreshFind(String email) {
		User user = entityManager.createQuery("select u from User u  where u.email =:email",User.class).setParameter("email", email).getSingleResult();
		System.out.println("returned user: " + user);
		entityManager.refresh(user);
		System.out.println("\n forced Returned user: " + user);
	}
}
package edu.mum.dao;

import edu.mum.domain.User;

public interface UserDao extends GenericDao<User> {
      
	public User findByEmail(String email);
	public void refreshFind(String email);
	public void saveFlush(User entity);
}

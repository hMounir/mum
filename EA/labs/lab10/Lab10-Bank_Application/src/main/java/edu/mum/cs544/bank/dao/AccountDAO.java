package edu.mum.cs544.bank.dao;

import java.util.*;

import edu.mum.cs544.bank.domain.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDAO implements IAccountDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		sessionFactory.getCurrentSession().persist(account); // add the new
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		sessionFactory.getCurrentSession().update(account);

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
		return sessionFactory.getCurrentSession().find(Account.class,accountnumber);
	}

	public Collection<Account> getAccounts() {
		return sessionFactory.getCurrentSession().createQuery("select a from Account a",Account.class).getResultList();
	}

}

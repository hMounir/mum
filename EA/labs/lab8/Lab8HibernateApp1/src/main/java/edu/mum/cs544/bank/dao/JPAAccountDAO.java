package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.util.EntityManagerHelper;

import javax.persistence.EntityGraph;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPAAccountDAO implements IAccountDAO{



    @Override
    public void saveAccount(Account account) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        EntityManagerHelper.getCurrent().persist(account);
        EntityManagerHelper.getCurrent().getTransaction().commit();
    }

    @Override
    public void updateAccount(Account account) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        EntityManagerHelper.getCurrent().merge(account);
        EntityManagerHelper.getCurrent().getTransaction().commit();
    }

    @Override
    public Account loadAccount(long accountnumber) {
        EntityManagerHelper.getCurrent().getTransaction().begin();

        EntityGraph<Account> entityGraph = EntityManagerHelper.getCurrent().createEntityGraph(Account.class);
        entityGraph.addAttributeNodes("customer");
        entityGraph.addSubgraph("entryList");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        Account account = EntityManagerHelper.getCurrent().find(Account.class,accountnumber,properties);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        return account;
    }

    @Override
    public Collection<Account> getAccounts() {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        List<Account> accounts = EntityManagerHelper.getCurrent().
                createQuery("SELECT DISTINCT a FROM Account a inner JOIN FETCH a.customer c inner JOIN FETCH a.entryList e",Account.class).getResultList();
        EntityManagerHelper.getCurrent().getTransaction().commit();
        return accounts;
    }
}

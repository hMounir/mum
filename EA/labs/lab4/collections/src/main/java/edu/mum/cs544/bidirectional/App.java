package edu.mum.cs544.bidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee("Hisham");
        employee.addLaptop(new Laptop("HP"));
        employee.addLaptop(new Laptop("Dell"));

        em.persist(employee);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted employees: ============== \n");
        em.createQuery("from Employee", Employee.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }
}


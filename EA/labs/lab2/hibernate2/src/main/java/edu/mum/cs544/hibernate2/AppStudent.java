package edu.mum.cs544.hibernate2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;

public class AppStudent {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("simpsons");

        //open entity manager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all students and print them
        em.createQuery("from Students", Students.class).getResultStream().forEach(System.out::println);

        //close the entity manager
        em.getTransaction().commit();
        em.close();

        //open entity manager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        // Create new instance of Student and set values in it
        Students student = new Students("Hisham Mohammed", "hmohammed@mum.edu","test");
        // save the student
        em.persist(student);

        //commit and close em
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all students and print them
        em.createQuery("from Students", Students.class).getResultStream().forEach(System.out::println);

        //commit the transaction and then close the entity manager
        em.getTransaction().commit();
        em.close();
    }
}


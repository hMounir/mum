package edu.mum.cs544.unidirectionalMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        School school = new School("Cambridge");
        school.addStudent(1,new Student("Hisham"));
        school.addStudent(2,new Student("Ahmed"));
        school.addStudent(3,new Student("Mohammed"));

        em.persist(school);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted schools: ============== \n");
        em.createQuery("from School", School.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }
}


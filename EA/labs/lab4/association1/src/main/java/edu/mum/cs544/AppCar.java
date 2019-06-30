package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00,new Owner("Hisham","FairField"));
        // save the car
        em.persist(car1);

        // Create new instance of Car and set values in it
        Car car2 = new Car("Tesla", "2018", 30221.00,new Owner("Jim","FairField"));
        // save the car
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        System.out.println("Persisted cars: ============== \n");
        em.createQuery("from Car", Car.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }
}


package edu.mum.cs544.unidirectionalList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Flight flight = new Flight("American Airlines");
        flight.addPassenger(new Passenger("Hisham"));
        flight.addPassenger(new Passenger("Ahmed"));
        flight.addPassenger(new Passenger("Mohammed"));

        em.persist(flight);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted flights: ============== \n");
        em.createQuery("from Flight", Flight.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }
}


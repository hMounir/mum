package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.*;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Doctor doctor = new Doctor("Eye doctor", "Frank", "Brown");
        Patient patient = new Patient("John Doe", "100 Main Street", "Boston", "23114");
        Payment payment = new Payment("12/06/08", 100);
        Appointment appointment = new Appointment("15/05/08", payment, patient, doctor);
        em.persist(appointment);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("from Appointment", Appointment.class).getResultList().forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}

package edu.mum.cs544;

import edu.mum.cs544.Book;
import edu.mum.cs544.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        //A- Create a Bidirectional OneToMany association between Department and Employee using annotations.
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department department = new Department("IT");
        department.addEmployee(new Employee("Hisham"));
        department.addEmployee(new Employee("Mohammed"));

        em.persist(department);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted employees: ============== \n");
        em.createQuery("from Department", Department.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();

        //B- Create an Optional Unidirectional ManyToOne association between Book and Publisher using annotations
        // and without using NULL fields in the database
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Publisher p = new Publisher("Fiction");

        Book b1 = new Book("Harry Potter 1", "3434", "JK Rolling", 5, new Date(), p);
        em.persist(b1);
        Book b2 = new Book("Harry Potter 2", "2323", "JK Rolling", 5, new Date(), p);
        em.persist(b2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted books: ============== \n");
        em.createQuery("from Book", Book.class).getResultList().forEach(System.out::println);

        em.getTransaction().commit();
        em.close();

        //C- Create a Bidirectional ManyToMany association between Student and Course using annotations. Be sure to make
        // studentid values application assigned (not generated)!
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Student s1 = new Student(1, "Hisham", "hmohammed@mum.edu", "011111");
        Student s2 = new Student(2, "Mohammed", "mohammed@mum.edu", "011111");
        Course c1 = new Course("WAA");
        Course c2 = new Course("EA");
        c1.addStudent(s1);
        c1.addStudent(s2);
        s1.addCourse(c1);
        s1.addCourse(c2);

        em.persist(c1);
        em.persist(c2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted courses: ============== \n");
        em.createQuery("from Course", Course.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();


        //D- Create a Unidirectional OneToMany association between Customer and Reservation using annotations
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Reservation r1 = new Reservation(new Date());
        Reservation r2 = new Reservation(new Date());
        Customer c = new Customer("Hisham");
        c.addReservation(r1);
        c.addReservation(r2);
        em.persist(c);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted customers: ============== \n");
        em.createQuery("from Customer", Customer.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();

        //E- Create a Unidirectional ManyToOne association between Reservation and Book using annotations.
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book1 = new Book("Angel and Demons", "3434", "Dan Brown", 5, new Date());
        Book book2 = new Book("Digital Code", "2323", "Dan Brown", 5, new Date());

        Reservation reservation1 = new Reservation(new Date(),book1);
        Reservation reservation2 = new Reservation(new Date(),book2);
        em.persist(reservation1);
        em.persist(reservation2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted reservations: ============== \n");
        em.createQuery("from Reservation r where r.book!=null", Reservation.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();

        //F- Create a Bidirectional ManyToOne association between Employee and Office using annotations.
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1 = new Employee("Harry");
        Employee employee2 = new Employee("Jim");
        department.addEmployee(employee1);
        department.addEmployee(employee2);
        Office o = new Office("NextGen");
        o.addEmployee(employee1);
        o.addEmployee(employee2);

        em.persist(o);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Persisted office: ============== \n");
        em.createQuery("from Office", Office.class).getResultList().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }
}

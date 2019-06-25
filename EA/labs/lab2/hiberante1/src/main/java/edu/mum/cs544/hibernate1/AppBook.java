package edu.mum.cs544.hibernate1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;

public class AppBook {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Book and set values in it
        Book book = new Book("Java", "Oracle","Hisham", 12.00,new Date());
        // save the book
        em.persist(book);
        // Create new instance of Book and set values in it
        book = new Book("Kotlin", "Google","Jim", 40.00,new Date());
        // save the book
        em.persist(book);
        // Create new instance of Book and set values in it
        book = new Book("Harry Potter", "WB","JK. Rolling", 20.00,new Date());
        // save the book
        em.persist(book);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all books and print them
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        query.getResultStream().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();

        //open the the entity manger
        em = emf.createEntityManager();
        em.getTransaction().begin();

        //change the title and price of one book
        book = em.createQuery("from Book b where b.id =:id", Book.class).setParameter("id",2).getSingleResult();
        book.setTitle("New Kotlin");
        book.setPrice(60.00);
        em.merge(book);
        System.out.println("book updated successfully\n");

        //delete different book with em.remove()
        Book bookToBeRemoved = em.find(Book.class,3);
        em.remove(bookToBeRemoved);
        em.getTransaction().commit();
        System.out.println("book removed successfully\n");

        //close the entity manager
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all books and print them
        em.createQuery("from Book", Book.class).getResultStream().forEach(System.out::println);

        //commit the transaction and then close the entity manager
        em.getTransaction().commit();
        em.close();
    }
}


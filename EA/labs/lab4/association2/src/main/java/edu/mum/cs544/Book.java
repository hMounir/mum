package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    private Date publish_date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book(String title, String ISBN, String author, double price, Date publish_date) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
    }

    public Book(String title, String ISBN, String author, double price, Date publish_date, Publisher publisher) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
        this.publisher = publisher;
    }
}

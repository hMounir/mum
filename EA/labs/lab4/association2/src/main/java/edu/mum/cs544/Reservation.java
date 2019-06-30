package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue
    private Integer id;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public Reservation(Date date) {
        this.date = date;
//        this.book = book;
    }

    public Reservation(Date date, Book book) {
        this.date = date;
        this.book = book;
    }
}

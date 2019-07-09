package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookDao extends JpaRepository<Book,Integer> {

}
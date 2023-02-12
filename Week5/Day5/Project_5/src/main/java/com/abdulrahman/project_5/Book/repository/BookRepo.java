package com.abdulrahman.project_5.Book.repository;

import com.abdulrahman.project_5.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    Book findBookByName(String name);
    List<Book> findAllByGenre(String genre);


}

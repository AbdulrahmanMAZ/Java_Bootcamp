package com.abdulrahman.final_Project.Appointments.repository;

import com.abdulrahman.final_Project.Appointments.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    Book findBookByName(String name);
    List<Book> findAllByGenre(String genre);


}

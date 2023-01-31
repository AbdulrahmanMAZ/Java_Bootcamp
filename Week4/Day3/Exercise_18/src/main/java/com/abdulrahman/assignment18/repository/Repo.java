package com.abdulrahman.assignment18.repository;

import com.abdulrahman.assignment18.model.Bootcamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Bootcamp,Integer> {
//    @Value("${database.query}")
//    String a="";
    Bootcamp findBootcampByTitleContainingIgnoreCase(String title);


//    @Query(a)
//    List<Bootcamp> findAllByTitle(String title);
}

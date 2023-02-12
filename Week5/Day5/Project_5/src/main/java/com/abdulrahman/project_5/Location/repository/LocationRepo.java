package com.abdulrahman.project_5.Location.repository;

import com.abdulrahman.project_5.Book.model.Book;
import com.abdulrahman.project_5.Location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location,Integer> {
    Location findLocationById(Integer id);

}

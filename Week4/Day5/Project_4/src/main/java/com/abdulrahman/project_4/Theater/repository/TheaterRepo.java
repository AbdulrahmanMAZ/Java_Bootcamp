package com.abdulrahman.project_4.Theater.repository;

import com.abdulrahman.project_4.Theater.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepo extends JpaRepository<Theater,Integer> {

    Theater findTheaterById(Integer id);
}

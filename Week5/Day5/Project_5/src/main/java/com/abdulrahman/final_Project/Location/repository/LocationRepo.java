package com.abdulrahman.final_Project.Location.repository;

import com.abdulrahman.final_Project.Location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location,Integer> {
    Location findLocationById(Integer id);

}

package com.abdulrahman.assignment19.director.repositroy;

import com.abdulrahman.assignment19.director.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepo extends JpaRepository<Director,String> {
    Director findDirectorById(Integer id);
}

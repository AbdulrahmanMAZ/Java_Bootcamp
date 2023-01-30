package com.abdulrahman.exercise_17.repository;

import com.abdulrahman.exercise_17.model.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Bootcamp,Integer> {
}

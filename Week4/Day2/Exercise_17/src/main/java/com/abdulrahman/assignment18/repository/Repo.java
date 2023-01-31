package com.abdulrahman.assignment18.repository;

import com.abdulrahman.assignment18.model.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Bootcamp,Integer> {
}

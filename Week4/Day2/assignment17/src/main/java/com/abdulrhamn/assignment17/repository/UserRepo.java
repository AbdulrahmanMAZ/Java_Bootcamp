package com.abdulrhamn.assignment17.repository;

import com.abdulrhamn.assignment17.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}

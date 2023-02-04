package com.abdulrahman.project_4.User.repository;

import com.abdulrahman.project_4.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

}

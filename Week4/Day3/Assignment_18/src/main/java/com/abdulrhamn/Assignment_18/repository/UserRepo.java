package com.abdulrhamn.Assignment_18.repository;

import com.abdulrhamn.Assignment_18.model.User;
import com.abdulrhamn.Assignment_18.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findUserByUserNameAndPassword(String user , String password);
    User findUserByEmail( String email);

    List<User> findAllByRole(String role);
    List<User> findAllByAgeGreaterThanEqual(Integer age);

}

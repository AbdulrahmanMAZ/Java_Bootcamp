package com.abdulrahman.assignment29_4tests.repository;

import com.abdulrahman.assignment29_4tests.model.MyUser;
import com.abdulrahman.assignment29_4tests.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

  List<Todo> findAllByMyUser(MyUser userId);
    List<Todo> findAllByMyUser_Id(Integer id);
    Todo findTodoById(Integer id);

}

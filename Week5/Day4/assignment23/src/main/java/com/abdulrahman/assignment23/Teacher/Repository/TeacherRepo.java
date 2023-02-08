package com.abdulrahman.assignment23.Teacher.Repository;

import com.abdulrahman.assignment23.Teacher.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
}

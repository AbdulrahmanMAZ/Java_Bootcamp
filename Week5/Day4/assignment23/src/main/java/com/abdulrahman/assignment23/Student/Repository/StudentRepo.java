package com.abdulrahman.assignment23.Student.Repository;

import com.abdulrahman.assignment23.Student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);

}

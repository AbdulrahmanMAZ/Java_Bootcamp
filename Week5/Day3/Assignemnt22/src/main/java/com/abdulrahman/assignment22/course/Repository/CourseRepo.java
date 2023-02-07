package com.abdulrahman.assignment22.course.Repository;

import com.abdulrahman.assignment22.TeacherAdress.Model.TeacherAddress;

import com.abdulrahman.assignment22.course.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);

}

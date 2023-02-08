package com.abdulrahman.assignment22.Course.Repository;

import com.abdulrahman.assignment22.Course.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);

}

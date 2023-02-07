package com.abdulrahman.assignment22.course.Service;


import com.abdulrahman.assignment22.Teacher.Model.Teacher;
import com.abdulrahman.assignment22.Teacher.Repository.TeacherRepo;
import com.abdulrahman.assignment22.course.Model.Course;
import com.abdulrahman.assignment22.course.Repository.CourseRepo;
import com.abdulrahman.assignment22.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class CourseService {
    private final CourseRepo courseRepo;
    private final TeacherRepo teacherRepo;

    public List<Course> getCourses() {
        return courseRepo.findAll();
    }
    public void addCourse(Course c) {
        Course course = courseRepo.findCourseById(c.getId());
        if (course == null) {
            throw new ApiException("No teacher found! ");
        }
//            Course course = new Course(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);
//        courseRepo.save(course);
    }
    public void editCourse(Integer id, Course course) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        Course teacherAddress = courseRepo.findCourseById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }
//        teacherAddress.setArea(TA_DTO.getArea());
//        teacherAddress.setStreet(TA_DTO.getStreet());
//        teacherAddress.setBuildingNumber(TA_DTO.getBuildingNumber());

//        Course teacherAddress = new Course(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);
        courseRepo.save(course);
    }
    public void deleteCourse(Integer id) {
        Course course = courseRepo.findCourseById(id);
        if (course == null) {
            throw new ApiException("No teacher found! ");
        }
        Course teacherAddress = courseRepo.findCourseById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }
}
}

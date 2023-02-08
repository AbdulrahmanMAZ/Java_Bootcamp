package com.abdulrahman.assignment22.Course.Service;


import com.abdulrahman.assignment22.Teacher.Model.Teacher;
import com.abdulrahman.assignment22.Teacher.Repository.TeacherRepo;
import com.abdulrahman.assignment22.Course.Model.Course;
import com.abdulrahman.assignment22.Course.Repository.CourseRepo;
import com.abdulrahman.assignment22.exception.ApiException;
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
    public void addCourse(Course course) {
//        Course course = courseRepo.findCourseById(c.getId());
//        if (course == null) {
//            throw new ApiException("No teacher found! ");
//        }
//        Course course = new Course(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);

        courseRepo.save(course);
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
    public void assignCourseToTeacher(Integer course_id,Integer teacher_id ){
        Course course = courseRepo.findCourseById(course_id);
        Teacher teacher = teacherRepo.findTeacherById(teacher_id);
        if (course == null||teacher == null) {
            throw new ApiException("No teacher found! ");
        }

        teacher.addCourses(course);
        course.setTeacher(teacher);
        courseRepo.save(course);
        teacherRepo.save(teacher);

    }

    public String returnTeacherName(Integer id) {
        Course course = courseRepo.findCourseById(id);
        if (course == null) {
            throw new ApiException("No teacher found! ");
        }
        if (course.getTeacher() == null) {
            throw new ApiException("No teacher found! for that specific teacher please assign a teacher by hitting this end point: localhost:8080/api/v3/{teacher_id}/course/{course_id} ");
        }
        Teacher teacher = teacherRepo.findTeacherById(course.getTeacher().getId());
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        return teacher.getName();
    }

}

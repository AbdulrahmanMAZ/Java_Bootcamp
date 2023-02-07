package com.abdulrahman.assignment22.course.Controller;

import com.abdulrahman.assignment22.TeacherAdress.DTO.TeacherAddressDTO;
import com.abdulrahman.assignment22.TeacherAdress.Model.TeacherAddress;
import com.abdulrahman.assignment22.course.Model.Course;
import com.abdulrahman.assignment22.course.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/teacher_address")
    public List<Course> readTeacheraddress(){
        return courseService.getCourses();
    }

    @PostMapping("/teacher_address")
    public ResponseEntity createCustomers(@RequestBody @Valid Course course) {

        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/teacher_address/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.editCourse(id,course);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/teacher_address/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){

        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Teacher address was deleted!");

    }



}

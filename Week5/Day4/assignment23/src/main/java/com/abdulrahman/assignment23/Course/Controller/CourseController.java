package com.abdulrahman.assignment23.Course.Controller;


import com.abdulrahman.assignment23.Course.Model.Course;
import com.abdulrahman.assignment23.Course.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/course")
    public List<Course> readCourse(){
        return courseService.getCourses();
    }

    @PostMapping("/course")
    public ResponseEntity createCourses(@RequestBody @Valid Course Course) {

        courseService.addCourse(Course);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/course/{id}")
    public ResponseEntity updateCourse(@PathVariable int id, @RequestBody @Valid Course course){
        courseService.editCourse(id,course);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/course/{id}")
    public ResponseEntity deleteMovies(@PathVariable Integer id){

        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course and address were deleted!");

    }


    // GET TEACHER INFO BY THE ID
//    @GetMapping("/course/{id}")
//    public Course getCourseById(@PathVariable Integer id){
//        return courseService.getCoursesById(id);
//    }
}

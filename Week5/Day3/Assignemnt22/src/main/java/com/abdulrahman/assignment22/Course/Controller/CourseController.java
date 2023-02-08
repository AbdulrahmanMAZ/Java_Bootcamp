package com.abdulrahman.assignment22.Course.Controller;

import com.abdulrahman.assignment22.Course.Model.Course;
import com.abdulrahman.assignment22.Course.Service.CourseService;
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

    @GetMapping("/course")
    public List<Course> readTeacheraddress(){
        return courseService.getCourses();
    }

    @PostMapping("/course")
    public ResponseEntity createCustomers(@RequestBody @Valid Course course) {

        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/course/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.editCourse(id,course);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/course/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){

        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Teacher address was deleted!");

    }




    //
    //

    // ASSIGN COURSE TO A TEACHER
    @PutMapping("{course_id}/course/{teacher_id}")
    public ResponseEntity assignTeacher(@PathVariable Integer course_id, @PathVariable Integer teacher_id){
        courseService.assignCourseToTeacher(course_id,teacher_id);
        return ResponseEntity.status(200).body("course is .successfully assigned to the teacher");
    }
    // GET THE TEACHER NAME OF THE COURSE
    @GetMapping("/course/{course_id}")
    public ResponseEntity returnTeacherName(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body( courseService.returnTeacherName(course_id));
    }


}

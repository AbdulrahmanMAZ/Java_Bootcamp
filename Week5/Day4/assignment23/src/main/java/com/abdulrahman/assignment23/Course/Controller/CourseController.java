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

    // ASSIGN TEACHER TO THE COURSE
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
    // ASSIGN STUDENTS TO THE COURSE
    @PutMapping("{course_id}/student/{student_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer course_id, @PathVariable Integer student_id){
        courseService.assignStudentToCourse(course_id,student_id);
        return ResponseEntity.status(200).body("student is successfully assigned to the course");
    }

}

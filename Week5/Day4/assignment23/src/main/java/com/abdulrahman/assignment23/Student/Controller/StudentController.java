package com.abdulrahman.assignment23.Student.Controller;


import com.abdulrahman.assignment23.Student.Model.Student;
import com.abdulrahman.assignment23.Student.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/student")
    public List<Student> readStudent(){
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public ResponseEntity createStudents(@RequestBody @Valid Student Student) {

        studentService.addStudent(Student);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/student/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Student student){
        studentService.editStudent(id,student);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteMovies(@PathVariable Integer id){

        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student and address were deleted!");

    }


    //  CHANGE THE MAJOR AND DELETE ALL THE COURSES FROM THE LIST OF COURSES
    @PutMapping("/student_id/{student_id}/new_major/{major}")
    public ResponseEntity changeMajor(@PathVariable int student_id,@PathVariable String major){
        studentService.changeMajor(student_id,major);
        return ResponseEntity.status(200).body("Updated");
    }



    // LIST ALL THE STUDENTS ASSIGNED TO THE COURSE
    @GetMapping("/students_list/{class_id}")
    public ResponseEntity getStudentsByClassId(@PathVariable Integer class_id){
        return ResponseEntity.status(200).body(studentService.getStudentsList(class_id));
    }
}

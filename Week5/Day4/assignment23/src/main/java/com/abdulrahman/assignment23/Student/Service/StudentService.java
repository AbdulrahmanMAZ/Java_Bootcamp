package com.abdulrahman.assignment23.Student.Service;


import com.abdulrahman.assignment23.Student.Model.Student;
import com.abdulrahman.assignment23.Student.Repository.StudentRepo;
import com.abdulrahman.assignment23.Teacher.Model.Teacher;
import com.abdulrahman.assignment23.Teacher.Repository.TeacherRepo;
import com.abdulrahman.assignment23.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final TeacherRepo teacherRepo;

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
    public Student getStudentName(Integer id) {
        Student student = studentRepo.findStudentById(id);
        if (student == null) {
            throw new ApiException("Not fount");
        }

        return student;
    }

    public void addStudent(Student student) {
//        Student student = studentRepo.findStudentById(c.getId());
//        if (student == null) {
//            throw new ApiException("No teacher found! ");
//        }
//        Student student = new Student(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);

        studentRepo.save(student);
    }
    public void editStudent(Integer id, Student student) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        Student teacherAddress = studentRepo.findStudentById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }
//        teacherAddress.setArea(TA_DTO.getArea());
//        teacherAddress.setStreet(TA_DTO.getStreet());
//        teacherAddress.setBuildingNumber(TA_DTO.getBuildingNumber());

//        Student teacherAddress = new Student(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);
        studentRepo.save(student);
    }
    public void deleteStudent(Integer id) {
        Student student = studentRepo.findStudentById(id);
        if (student == null) {
            throw new ApiException("No teacher found! ");
        }
        Student teacherAddress = studentRepo.findStudentById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }
}
    public void assignStudentToTeacher(Integer student_id,Integer teacher_id ){
        Student student = studentRepo.findStudentById(student_id);
        Teacher teacher = teacherRepo.findTeacherById(teacher_id);
        if (student == null||teacher == null) {
            throw new ApiException("No teacher found! ");
        }

//        teacher.addStudents(student);
        student.setTeacher(teacher);
        studentRepo.save(student);
        teacherRepo.save(teacher);

    }

    public String returnTeacherName(Integer id) {
        Student student = studentRepo.findStudentById(id);
        if (student == null) {
            throw new ApiException("No teacher found! ");
        }
        if (student.getTeacher() == null) {
            throw new ApiException("No teacher found! for that specific teacher please assign a teacher by hitting this end point: localhost:8080/api/v3/{teacher_id}/student/{student_id} ");
        }
        Teacher teacher = teacherRepo.findTeacherById(student.getTeacher().getId());
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        return teacher.getName();
    }

}

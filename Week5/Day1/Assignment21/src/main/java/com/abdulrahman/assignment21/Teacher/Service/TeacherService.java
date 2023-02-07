package com.abdulrahman.assignment21.Teacher.Service;



import com.abdulrahman.assignment21.Teacher.Model.Teacher;
import com.abdulrahman.assignment21.Teacher.Repository.TeacherRepo;
import com.abdulrahman.assignment21.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class TeacherService {

    private final TeacherRepo teacherRepo;

    public  void editTeacher(int id, Teacher teacher) {
        Teacher teacher_temp = teacherRepo.findTeacherById(id);
        if (teacher_temp == null) {
            throw new ApiException("not found");
        }
        teacher_temp.setAge(teacher.getAge() == null ? teacher_temp.getAge() : teacher.getAge());
        teacher_temp.setSalary(teacher.getSalary() == null ? teacher_temp.getSalary(): teacher.getSalary());
        teacher_temp.setEmail(teacher.getEmail() == "" ? teacher_temp.getEmail(): teacher.getEmail());
        teacher_temp.setName(teacher.getName() == "" ? teacher_temp.getName() : teacher.getName());

        teacherRepo.save(teacher_temp);
    }

    public List<Teacher> getTeacher() {
       return teacherRepo.findAll();
    }
    public void addTeacher(Teacher Teacher) {

        teacherRepo.save(Teacher);
    }
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("not found");
        }
        teacherRepo.delete(teacher);
    }

    public Teacher getTeacherById(Integer id) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Not found");
        }
        return teacher;
    }
}

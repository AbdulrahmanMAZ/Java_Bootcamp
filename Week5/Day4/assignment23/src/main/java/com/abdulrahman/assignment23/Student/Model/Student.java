package com.abdulrahman.assignment23.Student.Model;

import com.abdulrahman.assignment23.Course.Model.Course;
import com.abdulrahman.assignment23.Teacher.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "id")
    @Size(min = 10,max = 11)
    @Column(columnDefinition = "varchar(10) unique")
    private String student_id;
    @NotNull(message = "name")
    @Column(columnDefinition = "varchar(25)")
    private String  name;

    @NotNull(message = "age")
    @Column
    private Integer  age;

    @NotNull(message = "major")
    @Column(columnDefinition = "varchar(20)")
    private String  major;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name = "student_id") ,
            inverseJoinColumns = @JoinColumn(name = "course_id") )
    private Set<Course> courses;

    public void addCourse(Course course
    ){
        this.courses.add(course);
    }
    public void emptyCourses(){
        this.courses.clear();
    }
}

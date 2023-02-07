package com.abdulrahman.assignment22.course.Model;

import com.abdulrahman.assignment22.Teacher.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String  name;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}

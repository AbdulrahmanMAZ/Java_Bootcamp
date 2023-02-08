package com.abdulrahman.assignment23.Course.Model;

import com.abdulrahman.assignment23.Teacher.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(columnDefinition = "varchar(15) unique")
    private String  name;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}

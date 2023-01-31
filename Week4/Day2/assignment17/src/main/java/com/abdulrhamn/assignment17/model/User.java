package com.abdulrhamn.assignment17.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4)
    @Column
    private String name;

    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(25) unique not null")
    private String userName;

    @NotEmpty
//    @NotNull
    @Pattern(regexp = "^.+@.+\\.\\w{2,}$" , message = "must be in this form XXX@XX.XX")
    @Column(columnDefinition = "varchar(40) unique not null")
    private String email;

//    @NotEmpty
    @NotEmpty
//@NotNull
    @Size
//    @Pattern(regexp = "^admin||user$")
    @Column(columnDefinition = "varchar(10)  CHECK (role='admin' || role='user')")
    private String role;

//    @Column(columnDefinition = "int check(age >0)" )
    @NotNull
    @Positive
    @Column
    private Integer age;



}

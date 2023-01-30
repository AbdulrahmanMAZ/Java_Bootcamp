package com.abdulrhamn.assignment17.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @NotNull
    @Pattern(regexp = "^.+@.+\\.\\w{2,}$")
    @Column(columnDefinition = "varchar(40) unique not null")
    private String email;

    @NotEmpty
    @Size
    @Pattern(regexp = "^admin||user$")
//    @Column(columnDefinition = "varchar(10) check ( role ='admin' or gender ='user') not null")
    private String role;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer age;



}

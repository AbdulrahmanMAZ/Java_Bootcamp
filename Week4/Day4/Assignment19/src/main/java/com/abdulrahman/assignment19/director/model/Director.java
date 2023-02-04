package com.abdulrahman.assignment19.director.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "not null")
//    @Size(min = 3)
    Integer id;

    @NotNull
    @NotEmpty
    @Size(min=2)
    @Column
    String name;

}

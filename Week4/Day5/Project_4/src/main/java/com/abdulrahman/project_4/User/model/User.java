package com.abdulrahman.project_4.User.model;

import com.abdulrahman.project_4.Food.model.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "user name is required")
    private String name;
//    private Boolean isPresent = false;

    private Integer theaterID;
    private Integer MovieID;

    @ElementCollection
    private List<Food> foodList;

    private int total = 0;
}

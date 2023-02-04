package com.abdulrahman.project_4.Movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(30) unique")
    String title;
    @NotNull
    @PositiveOrZero
    Integer price;
    @NotNull
    @NotEmpty
    String genre;
    @NotNull
    Integer duration;
    Integer theaterID;


}

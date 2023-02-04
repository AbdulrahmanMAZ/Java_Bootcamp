package com.abdulrahman.assignment19.movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
//@Column(columnDefinition = "AUTO_INCREMENT = 300")

//    @Size(min = 3)
    Integer id;

    @NotNull
    @NotEmpty
    @Size(min=2)
    @Column
    String name;

//    @NotNull
    @Column(columnDefinition = "varchar(15)  CHECK (genre='Drama' || genre='Action'|| genre='Comedy')")
    String genre;

    @NotNull
    @Min(1)
    @Max(5)
    Integer rate;

    @NotNull
    @Min(60)
    Integer duration;

    @NotNull
    @Column
//    @Size(min = 2)
    Integer directorID;
}

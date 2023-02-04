package com.abdulrahman.project_4.Movie.repository;

import com.abdulrahman.project_4.Movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Integer> {

    Movie findMovieByTitle(String title);

}

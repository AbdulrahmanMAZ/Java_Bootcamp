package com.abdulrahman.assignment19.movie.repository;

import com.abdulrahman.assignment19.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,String> {
    Movie findMovieByNameContains(String name);
    List<Movie> findAllByDirectorID(Integer id);
    List<Movie> findAllByRateGreaterThan(Integer rate);
    List<Movie> findAllByGenre(String genre);


}

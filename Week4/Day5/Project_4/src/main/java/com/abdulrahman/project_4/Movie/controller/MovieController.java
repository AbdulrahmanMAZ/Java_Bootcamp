package com.abdulrahman.project_4.Movie.controller;

import com.abdulrahman.project_4.Movie.model.Movie;
import com.abdulrahman.project_4.Movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    final MovieService movieService;
    @GetMapping("/get")
    public List<Movie> readMovies(){
        return movieService.getMovie();
    }
    @PostMapping("/add")
    public ResponseEntity createMovies(@RequestBody @Valid Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovies(@PathVariable Integer id, @RequestBody @Valid Movie movie){
        movieService.editMovie(id,movie);
        return ResponseEntity.status(200).body("Movie modified!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovies(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted!");
    }

    @GetMapping("/get-theater-title/{title}")
    public ResponseEntity readMovies(@PathVariable String title){
        String theaterTitle =  movieService.findTheaterByMovieName(title);
        return ResponseEntity.status(200).body("Theater name: " + theaterTitle);
    }

}

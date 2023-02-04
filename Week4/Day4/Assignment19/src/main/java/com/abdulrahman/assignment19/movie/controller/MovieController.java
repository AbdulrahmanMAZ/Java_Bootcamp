package com.abdulrahman.assignment19.movie.controller;


import com.abdulrahman.assignment19.director.service.DirectorService;
import com.abdulrahman.assignment19.movie.model.Movie;

import com.abdulrahman.assignment19.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
@RequiredArgsConstructor
public class MovieController {
    final MovieService movieService;
    final DirectorService directorService;

    @GetMapping("/movie")
    public List<Movie> readMovies(){
        return movieService.getMovie();
    }
    @PostMapping("/movie")
    public ResponseEntity createMovies(@RequestBody @Valid Movie movie) {

        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Added");

    }
    @PutMapping("/movie/{id}")
    public ResponseEntity updateMovies(@PathVariable String id, @RequestBody @Valid Movie movie){

        movieService.editMovie(id,movie);
        return ResponseEntity.status(200).body("Movie modified!");

    }
    @DeleteMapping("/movie/{id}")
    public ResponseEntity deleteMovies(@PathVariable String id){

        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted!");

    }
    @GetMapping("/byname/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){

        Movie movie = movieService.findMovieByTitle(name);
        return ResponseEntity.status(200).body(movie);

    }
    @GetMapping("/duration/{name}")
    public ResponseEntity getMovieByNameAndReturnDuration(@PathVariable String name){
        Movie movie = movieService.findMovieByTitle(name);
        return ResponseEntity.status(200).body(movie.getDuration());
    }
    @GetMapping("/moviedirector/{name}")
    public ResponseEntity getMovieByNameAndReturnDirector(@PathVariable String name){
        Movie movie = movieService.findMovieByTitle(name);
        com.abdulrahman.assignment19.director.model.Director director = directorService.findDirectorById(movie.getDirectorID());
        return ResponseEntity.status(200).body(director);
    }
    @GetMapping("/byrate/{name}")
    public ResponseEntity getMovieRateByName(@PathVariable String name){

        Movie movie = movieService.findMovieByTitle(name);
        return ResponseEntity.status(200).body(movie.getRate());

    }
    @GetMapping("/allbyrate/{rate}")
    public ResponseEntity getAllMoviesRate(@PathVariable Integer rate){

        List<Movie> movies = movieService.findMoviesByRate(rate);
        return ResponseEntity.status(200).body(movies);

    }
    @GetMapping("/allbygenre/{genre}")
    public ResponseEntity getAllMoviesGenre(@PathVariable String genre){

        List<Movie> movies = movieService.findMoviesByGenre(genre);
        return ResponseEntity.status(200).body(movies);

    }

    // CHECK IF THE USERNAME AND PASSWORD ARE CORRECT
//    @GetMapping("/login")
//    public ResponseEntity checkCredintals(@RequestBody MovieCredential movieCredential){
//
//        movieService.checkMovieCredential(movieCredential);
//        return ResponseEntity.status(200).body("Correct credential");
//
//    }

//    @GetMapping("/byrole/{role}")
//    public ResponseEntity getAllByRole(@PathVariable String role){
//
//        List<Movie> movie = movieService.findAllRoles(role);
//        return ResponseEntity.status(200).body(movie);
//
//    }
//    @GetMapping("/byage/{age}")
//    public ResponseEntity getAllByAge(@PathVariable Integer age){
//
//        List<Movie> movie = movieService.findAllAge(age);
//        return ResponseEntity.status(200).body(movie);
//
//    }

}

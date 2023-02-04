package com.abdulrahman.assignment19.director.controller;


import com.abdulrahman.assignment19.director.service.DirectorService;
import com.abdulrahman.assignment19.director.model.Director;
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
public class DirectorController {
    final MovieService movieService;
    final DirectorService directorService;

    @GetMapping("/director")
    public List<Director> readMovies(){
        return directorService.getDirector();
    }

    @PostMapping("/director")
    public ResponseEntity createMovies(@RequestBody @Valid Director director) {

        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/director/{id}")
    public ResponseEntity updateMovies(@PathVariable String id, @RequestBody @Valid Director director, Errors errors){

        directorService.editDirector(id,director);
        return ResponseEntity.status(200).body("Movie modified!");

    }
    @DeleteMapping("/director/{id}")
    public ResponseEntity deleteMovies(@PathVariable String id){

        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Movie deleted!");

    }
    @GetMapping("/allmovies/{id}")
    public ResponseEntity getDirectorMovies(@PathVariable Integer id){

        List<Movie> movies = directorService.findAllMoviesByDirector(id);
        return ResponseEntity.status(200).body(movies);

    }
//    @GetMapping("/byname/{name}")
//    public ResponseEntity getMovieByNameAndReturnDuration(@PathVariable String name){
//        Director director = directorService.findMovieByTitle(name);
//        return ResponseEntity.status(200).body(director.getDuration());
//    }
//    @GetMapping("/byname/{name}")
//    public ResponseEntity getMovieByNameAndReturnDirector(@PathVariable String name){
//        Director director = directorService.findMovieByTitle(name);
//        com.abdulrahman.assignment19.director.model.Director director = directorService.findDirectorById(director.getDirectorID());
//        return ResponseEntity.status(200).body(director);
//    }
    // CHECK IF THE USERNAME AND PASSWORD ARE CORRECT
//    @GetMapping("/login")
//    public ResponseEntity checkCredintals(@RequestBody MovieCredential directorCredential){
//
//        directorService.checkMovieCredential(directorCredential);
//        return ResponseEntity.status(200).body("Correct credential");
//
//    }

//    @GetMapping("/byrole/{role}")
//    public ResponseEntity getAllByRole(@PathVariable String role){
//
//        List<Movie> director = directorService.findAllRoles(role);
//        return ResponseEntity.status(200).body(director);
//
//    }
//    @GetMapping("/byage/{age}")
//    public ResponseEntity getAllByAge(@PathVariable Integer age){
//
//        List<Movie> director = directorService.findAllAge(age);
//        return ResponseEntity.status(200).body(director);
//
//    }

}

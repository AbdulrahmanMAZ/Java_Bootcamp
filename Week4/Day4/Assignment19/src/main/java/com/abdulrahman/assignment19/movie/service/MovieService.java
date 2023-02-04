package com.abdulrahman.assignment19.movie.service;


import com.abdulrahman.assignment19.director.repositroy.DirectorRepo;
import com.abdulrahman.assignment19.exception.ApiException;
import com.abdulrahman.assignment19.movie.model.Movie;
import com.abdulrahman.assignment19.movie.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    final MovieRepo movieRepo;
    final DirectorRepo directorRepo;

    public List<Movie> getMovie() {
         List<Movie> movies = movieRepo.findAll();
        return movies;
    }
    public void addMovie(Movie movie) {
        // does director exist
        if (directorRepo.findDirectorById(movie.getDirectorID()) == null) {
            throw  new ApiException("Director id not found");
        }
        movieRepo.save(movie);
    }
    public boolean editMovie(String id, Movie movie) {
        Movie temp_Movie = movieRepo.findById(id).get();
        if (temp_Movie == null) {
            return false;
        }

        temp_Movie.setName(movie.getName());
        temp_Movie.setDuration(movie.getDuration());
        temp_Movie.setGenre(movie.getGenre());
        temp_Movie.setRate(movie.getRate());


    try{
        movieRepo.save(temp_Movie);
        return true;

    }catch (DataIntegrityViolationException e){
        return false;
    }
    }
    public boolean deleteMovie(String id) {
        Movie temp_Movie = movieRepo.getById(id);
        if (temp_Movie == null) {
            return false;
        }
        movieRepo.delete(temp_Movie);
        return true;
    }
    public Movie findMovieByTitle(String name) {
        Movie movie = movieRepo.findMovieByNameContains(name);
        if (movie == null) {
            throw new ApiException("Not found");
        }
        return movie;
    }
    public List<Movie> findMoviesByRate(Integer rate) {
        List<Movie> movies = movieRepo.findAllByRateGreaterThan(rate);
        if (movies == null) {
            throw new ApiException("Not found");
        }
        return movies;
    }
    public List<Movie> findMoviesByGenre(String genre) {
        List<Movie> movies = movieRepo.findAllByGenre(genre);
        if (movies == null) {
            throw new ApiException("Not found");
        }
        return movies;
    }
//    public boolean checkMovieCredential(MovieCredential movieCredential) {
//        Movie movie = movieRepo.findMovieByMovieNameAndPassword(movieCredential.movieName(), movieCredential.password());
//        if (movie == null) {
//            throw new ApiException("Wrong credential");
//        }
//        return true;
//    }

//    public List<Movie> findAllRoles(String role) {
//        List<Movie> movies = movieRepo.findAllByRole(role);
//        if (movies == null) {
//            throw new ApiException("Enter a correct role");
//        }
//        return movies;
//    }
//    public List<Movie> findAllAge(Integer age) {
//        List<Movie> movies = movieRepo.findAllByAgeGreaterThanEqual(age);
//        if (movies == null) {
//            throw new ApiException("Enter a correct role");
//        }
//        return movies;
//    }

}

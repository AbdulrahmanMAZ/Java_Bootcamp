package com.abdulrahman.project_4.Movie.service;

import com.abdulrahman.project_4.Movie.model.Movie;
import com.abdulrahman.project_4.Movie.repository.MovieRepo;
import com.abdulrahman.project_4.Theater.model.Theater;
import com.abdulrahman.project_4.Theater.repository.TheaterRepo;
import com.abdulrahman.project_4.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepo movieRepo;
    private final TheaterRepo theaterRepo;
    public List<Movie> getMovie() {
        List<Movie> movies = movieRepo.findAll();
        return movies;
    }
    public void addMovie(Movie movie) {

        movieRepo.save(movie);
    }
    public boolean editMovie(Integer id, Movie movie) {
        Movie temp_Movie = movieRepo.findById(id).get();
        if (temp_Movie == null) {
            return false;
        }

        temp_Movie.setTitle(movie.getTitle());
        temp_Movie.setDuration(movie.getDuration());
        temp_Movie.setGenre(movie.getGenre());
        temp_Movie.setPrice(movie.getPrice());


        try{
            movieRepo.save(temp_Movie);
            return true;

        }catch (DataIntegrityViolationException e){
            return false;
        }
    }
    public boolean deleteMovie(Integer id) {
        Movie temp_Movie = movieRepo.getById(id);
        if (temp_Movie == null) {
            return false;
        }
        movieRepo.delete(temp_Movie);
        return true;
    }



    public String findTheaterByMovieName(String title) {
        Movie movie = movieRepo.findMovieByTitle(title);
        if(movie == null) {
            throw new ApiException("Can't find the movie");
        }
        Theater theater = theaterRepo.findTheaterById(movie.getTheaterID());
        return theater.getTitle();
    }
}

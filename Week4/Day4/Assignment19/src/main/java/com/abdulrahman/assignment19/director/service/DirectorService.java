package com.abdulrahman.assignment19.director.service;

import com.abdulrahman.assignment19.director.model.Director;
import com.abdulrahman.assignment19.exception.ApiException;

import com.abdulrahman.assignment19.director.repositroy.DirectorRepo;
import com.abdulrahman.assignment19.movie.model.Movie;
import com.abdulrahman.assignment19.movie.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {


        final DirectorRepo directorRepo;
        final MovieRepo movieRepo;
        public List<Director> getDirector() {
            List<Director> directors = directorRepo.findAll();

            return directors;
        }
        public void addDirector(Director director) {

            directorRepo.save(director);
        }
        public boolean editDirector(String id, Director director) {
            Director temp_Director = directorRepo.findById(id).get();
            if (temp_Director == null) {
                return false;
            }

            temp_Director.setName(director.getName());


            try{
                directorRepo.save(temp_Director);
                return true;

            }catch (DataIntegrityViolationException e){
                return false;
            }
        }
        public boolean deleteDirector(String id) {
            Director temp_Director = directorRepo.getById(id);
            if (temp_Director == null) {
                return false;
            }
            directorRepo.delete(temp_Director);
            return true;
        }
        public Director findDirectorById(Integer id) {
            Director director = directorRepo.findDirectorById(id);
            if (director == null) {
                throw new ApiException("Not found");
            }
            return director;
        }
        public List<Movie> findAllMoviesByDirector(Integer id) {
        List<Movie> movies = movieRepo.findAllByDirectorID(id);
        if (movies == null) {
            throw new ApiException("Not found");
        }
        return movies;
    }




        //    public boolean checkDirectorCredential(DirectorCredential directorCredential) {
//        Director director = directorRepo.findDirectorByDirectorNameAndPassword(directorCredential.directorName(), directorCredential.password());
//        if (director == null) {
//            throw new ApiException("Wrong credential");
//        }
//        return true;
//    }

//    public List<Director> findAllRoles(String role) {
//        List<Director> directors = directorRepo.findAllByRole(role);
//        if (directors == null) {
//            throw new ApiException("Enter a correct role");
//        }
//        return directors;
//    }
//    public List<Director> findAllAge(Integer age) {
//        List<Director> directors = directorRepo.findAllByAgeGreaterThanEqual(age);
//        if (directors == null) {
//            throw new ApiException("Enter a correct role");
//        }
//        return directors;
//    }


}

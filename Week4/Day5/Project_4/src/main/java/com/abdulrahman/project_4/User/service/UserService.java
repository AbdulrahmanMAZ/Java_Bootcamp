package com.abdulrahman.project_4.User.service;

import com.abdulrahman.project_4.Food.model.Food;
import com.abdulrahman.project_4.Food.repository.FoodRepo;
import com.abdulrahman.project_4.Movie.model.Movie;
import com.abdulrahman.project_4.Movie.repository.MovieRepo;
import com.abdulrahman.project_4.Theater.model.Theater;
import com.abdulrahman.project_4.Theater.repository.TheaterRepo;
import com.abdulrahman.project_4.Theater.service.TheaterService;
import com.abdulrahman.project_4.User.model.User;
import com.abdulrahman.project_4.User.repository.UserRepo;
import com.abdulrahman.project_4.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final MovieRepo movieRepo;
    private final TheaterRepo theaterRepo;
    private final TheaterService theaterService;
    private final FoodRepo foodRepo;

    public List<User> getUser() {
        List<User> users = userRepo.findAll();
        return users;
    }
    public void addUser(User user) {

        userRepo.save(user);
    }
    public boolean editUser(Integer id, User user) {
        User temp_User = userRepo.findById(id).get();
        if (temp_User == null) {
            return false;
        }

        temp_User.setName(user.getName());
        temp_User.setMovieID(user.getMovieID());
        temp_User.setTheaterID(user.getTheaterID());

        try{
            userRepo.save(temp_User);
            return true;

        }catch (DataIntegrityViolationException e){
            return false;
        }
    }
    public boolean deleteUser(Integer id) {
        User temp_User = userRepo.getById(id);
        if (temp_User == null) {
            return false;
        }
        userRepo.delete(temp_User);
        return true;
    }

    public void userBookMovie(Integer id, String title) {
        Movie movieName = movieRepo.findMovieByTitle(title); // avatar
        User user = userRepo.findUserById(id);
        Theater theater = theaterRepo.findTheaterById(movieName.getTheaterID());

        if(movieName == null) {
            throw new ApiException("Movie not found!");
        }

        if(theaterService.checkAvailability(theater.getId()) == 0) {
            throw new ApiException("No seats available");
        }

        if(user == null) {
            throw new ApiException("user wrong id");
        }

        user.setTheaterID(movieName.getTheaterID());
        user.setMovieID(movieName.getId());
        user.setTotal(user.getTotal() + movieName.getPrice());
        theater.setCapacity(theater.getCapacity() - 1);
        theaterRepo.save(theater);
        userRepo.save(user);
    }

    public void userBuyFood(Integer id, String name) {
        User user = userRepo.findUserById(id);
        Food food =  foodRepo.findFoodByName(name);

        if(user == null) {
            throw new ApiException("user wrong id");
        }
        if(food == null) {
            throw new ApiException("food name not found!");
        }

        List<Food> oldFoodList = user.getFoodList();
        oldFoodList.add(food);
        int foodPrice = food.getPrice();
        user.setTotal(user.getTotal()+foodPrice);
        user.setFoodList(oldFoodList);
        userRepo.save(user);
    }



}

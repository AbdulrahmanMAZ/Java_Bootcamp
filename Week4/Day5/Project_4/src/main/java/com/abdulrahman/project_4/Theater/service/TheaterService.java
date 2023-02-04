package com.abdulrahman.project_4.Theater.service;

import com.abdulrahman.project_4.Theater.model.Theater;
import com.abdulrahman.project_4.Theater.repository.TheaterRepo;
import com.abdulrahman.project_4.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TheaterService {
    final TheaterRepo theaterRepo;
    public List<Theater> getTheater() {
        List<Theater> theaters = theaterRepo.findAll();
        return theaters;
    }
    public void addTheater(Theater theater) {

        theaterRepo.save(theater);
    }
    public boolean editTheater(Integer id, Theater theater) {
        Theater temp_Theater = theaterRepo.findById(id).get();
        if (temp_Theater == null) {
            return false;
        }

        temp_Theater.setTitle(theater.getTitle());
        temp_Theater.setIsAvailable(theater.getIsAvailable());
        temp_Theater.setCapacity(theater.getCapacity());



        try{
            theaterRepo.save(temp_Theater);
            return true;

        }catch (DataIntegrityViolationException e){
            return false;
        }
    }
    public boolean deleteTheater(Integer id) {
        Theater temp_Theater = theaterRepo.getById(id);
        if (temp_Theater == null) {
            return false;
        }
        theaterRepo.delete(temp_Theater);
        return true;
    }

    public Integer checkAvailability(Integer id) {
        Theater temp = theaterRepo.findTheaterById(id);
        if (temp == null){
            throw new ApiException("Not a correct theater id");
        }
        Integer availableSeats = temp.getCapacity();
        if (availableSeats > 0){
            return temp.getCapacity();
        } else {
            throw new ApiException("No seat available, theater is full");
        }

    }
}

package com.abdulrahman.project_4.Theater.controller;

import com.abdulrahman.project_4.Theater.model.Theater;
import com.abdulrahman.project_4.Theater.service.TheaterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theater")
@RequiredArgsConstructor
public class TheaterController {
    final TheaterService theaterService;
    @GetMapping("/get")
    public List<Theater> getTheaters(){
        return theaterService.getTheater();
    }
    @PostMapping("/add")
    public ResponseEntity addTheater(@RequestBody @Valid Theater theater) {

        theaterService.addTheater(theater);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTheaters(@PathVariable Integer id, @RequestBody @Valid Theater theater){

        theaterService.editTheater(id, theater);
        return ResponseEntity.status(200).body("Theater modified!");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTheaters(@PathVariable Integer id){

        theaterService.deleteTheater(id);
        return ResponseEntity.status(200).body("Theater deleted!");

    }

    @GetMapping("/theater-seats/{id}")
    public ResponseEntity checkIfTheaterIsAvailable(@PathVariable Integer id){
        Integer theater = theaterService.checkAvailability(id);
        return ResponseEntity.status(200).body("Theater seats: " +  theater);
    }

}

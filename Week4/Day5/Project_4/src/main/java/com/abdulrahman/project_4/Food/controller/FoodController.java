package com.abdulrahman.project_4.Food.controller;

import com.abdulrahman.project_4.Food.service.FoodService;
import com.abdulrahman.project_4.Food.model.Food;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class FoodController {
    final FoodService foodService;
    @GetMapping("/get")
    public List<Food> readFoods(){
        return foodService.getFood();
    }
    @PostMapping("/add")
    public ResponseEntity createFoods(@RequestBody @Valid Food food) {

        foodService.addFood(food);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateFoods(@PathVariable Integer id, @RequestBody @Valid Food food){

        foodService.editFood(id,food);
        return ResponseEntity.status(200).body("Food modified!");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFoods(@PathVariable Integer id){

        foodService.deleteFood(id);
        return ResponseEntity.status(200).body("Food deleted!");

    }

}

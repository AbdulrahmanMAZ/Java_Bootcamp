package com.abdulrahman.project_4.Food.service;

import com.abdulrahman.project_4.Food.model.Food;
import com.abdulrahman.project_4.Food.repository.FoodRepo;
import com.abdulrahman.project_4.Food.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FoodService {
    final FoodRepo foodRepo;
    public List<Food> getFood() {
        List<Food> foods = foodRepo.findAll();
        return foods;
    }
    public void addFood(Food food) {

        foodRepo.save(food);
    }
    public boolean editFood(Integer id, Food food) {
        Food temp_Food = foodRepo.findById(id).get();
        if (temp_Food == null) {
            return false;
        }

        temp_Food.setPrice(food.getPrice());
        temp_Food.setName(food.getName());


        try{
            foodRepo.save(temp_Food);
            return true;

        }catch (DataIntegrityViolationException e){
            return false;
        }
    }
    public boolean deleteFood(Integer id) {
        Food temp_Food = foodRepo.getById(id);
        if (temp_Food == null) {
            return false;
        }
        foodRepo.delete(temp_Food);
        return true;
    }


}

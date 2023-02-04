package com.abdulrahman.project_4.Food.repository;

import com.abdulrahman.project_4.Food.model.Food;
import com.abdulrahman.project_4.Movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {

    Food findFoodByName(String name);
}

package com.abdulrahman.assignment_15.Category.controller;

import com.abdulrahman.assignment_15.Category.module.Category;
import com.abdulrahman.assignment_15.Category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/category")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body( categoryService.getCategory());
    }
    @PostMapping("/category")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body( "Category Added");
    }
    @PutMapping("/category/{categoryID}")
    public ResponseEntity editCategory(@PathVariable String categoryID,@Valid @RequestBody Category category, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.editCategory(categoryID,category);
        return ResponseEntity.status(200).body( "Category Updated");
    }
    @DeleteMapping("/category/{categoryID}")
    public ResponseEntity deleteCategory(@PathVariable int categoryID){

        categoryService.deleteCategory(categoryID);
        return ResponseEntity.status(200).body( "Category Deleted");
    }

}

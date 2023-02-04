package com.abdulrahman.project_4.User.controller;

import com.abdulrahman.project_4.User.model.User;
import com.abdulrahman.project_4.User.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    @GetMapping("/get")
    public List<User> readUsers(){
        return userService.getUser();
    }
    @PostMapping("/add")
    public ResponseEntity createUsers(@Valid @RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id, @RequestBody @Valid User user){

        userService.editUser(id, user);
        return ResponseEntity.status(200).body("User modified!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable Integer id){

        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted!");

    }

    @PutMapping("/booking/{userId}/{title}")
    public ResponseEntity userBookMovie(@PathVariable Integer userId, @PathVariable String title) {
        userService.userBookMovie(userId,title);
        return ResponseEntity.status(200).body("User booked a movie");
    }

    @PutMapping("/buy-food/{userId}/{foodName}")
    public ResponseEntity userBuyFood(@PathVariable Integer userId, @PathVariable String foodName) {
        userService.userBuyFood(userId, foodName);
        return ResponseEntity.status(200).body("User bought: " + foodName);
    }
}

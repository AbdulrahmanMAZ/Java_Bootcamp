package com.abdulrhamn.assignment17.controller;


import com.abdulrhamn.assignment17.model.User;
import com.abdulrhamn.assignment17.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    @GetMapping("/user")
    public List<User> readUsers(){
        return userService.getUser();
    }
    @PostMapping("/user")
    public ResponseEntity createUsers(@RequestBody @Valid User bootcamp, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            userService.addUser(bootcamp);
            return ResponseEntity.status(200).body("User added!");

        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(400).body("User name already exists");

        }

    }
    @PutMapping("/user/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id, @RequestBody @Valid User bootcamp, Errors errors){
        if (errors.hasErrors()||userService.editUser(id,bootcamp) == false) {
            return ResponseEntity.status(400).body("WROOOOONG");
        }

        userService.editUser(id,bootcamp);
        return ResponseEntity.status(200).body("User modified!");

    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUsers(@PathVariable Integer id){
        if (userService.deleteUser(id) == false) {
            return ResponseEntity.status(400).body("WROOOOONG");
        }

        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted!");

    }

}

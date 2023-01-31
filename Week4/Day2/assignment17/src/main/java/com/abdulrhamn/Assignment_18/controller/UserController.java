package com.abdulrhamn.Assignment_18.controller;


import com.abdulrhamn.Assignment_18.model.User;
import com.abdulrhamn.Assignment_18.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    @ExceptionHandler(value = Exception.class)
    @PostMapping("/user")
    public ResponseEntity createUsers(@RequestBody @Valid User bootcamp, Errors errors) throws Exception  {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            userService.addUser(bootcamp);
            return ResponseEntity.status(200).body("User added!");

        }catch (HttpMessageNotReadableException e){
            return ResponseEntity.status(400).body("Age must be a number name already exists");

        }
        catch (DataIntegrityViolationException e){
            if(e.toString().contains("email")){
                return ResponseEntity.status(400).body("Email already exists");

            } else if(e.toString().contains("user_name")){
                return ResponseEntity.status(400).body("User name already exists");
            }
            else{
                return ResponseEntity.status(400).body("role not valid");
            }





        }


        catch (Exception e){
            return ResponseEntity.status(400).body("Something went wrong");

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

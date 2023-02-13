package com.abdulrahman.blog_system.Auth;

import com.abdulrahman.blog_system.MyUser.MyUser;
import com.abdulrahman.blog_system.MyUser.MyUserController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/register")
    public ResponseEntity register(@RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.OK).body("User Registered successfully");
    }
    @GetMapping("/login")
    public ResponseEntity login(@RequestBody MyUser myUser){
        return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully");
    }
}

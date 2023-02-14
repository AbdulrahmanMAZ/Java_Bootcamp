package com.abdulrahman.store.Auth;

import com.abdulrahman.store.MyUser.MyUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.OK).body("User Registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully");
    }
}

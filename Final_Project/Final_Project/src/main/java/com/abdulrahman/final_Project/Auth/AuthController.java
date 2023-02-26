package com.abdulrahman.final_Project.Auth;

import com.abdulrahman.final_Project.MyUser.MyUser;
import com.abdulrahman.final_Project.helper.AdvisorRegisterFormDAO;
import com.abdulrahman.final_Project.helper.StartUpRegisterFormDAO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/advisor")
    public ResponseEntity registerAdvisor(@Valid @RequestBody AdvisorRegisterFormDAO myUser){
        authService.registerAdvisor(myUser);

        return ResponseEntity.status(HttpStatus.OK).body("Advisor has Registered successfully");
    }
    @PostMapping("/register/start-up")
    public ResponseEntity registerStartUp(@Valid @RequestBody StartUpRegisterFormDAO myUser){
        authService.registerStartUp(myUser);
        return ResponseEntity.status(HttpStatus.OK).body("Start up has Registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity login(@AuthenticationPrincipal MyUser myUser){

        if (myUser.getRole().equals("ADMIN")) {
            return ResponseEntity.status(HttpStatus.OK).body("Welcome Admin");
        } else if (myUser.getRole().equals("STARTUP")) {
            return ResponseEntity.status(HttpStatus.OK).body("Welcome Start Up");
        } else if (myUser.getRole().equals("ADVISOR")) {
            return ResponseEntity.status(HttpStatus.OK).body("Welcome Advisor");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body("Welcome You");
        }

        }

}


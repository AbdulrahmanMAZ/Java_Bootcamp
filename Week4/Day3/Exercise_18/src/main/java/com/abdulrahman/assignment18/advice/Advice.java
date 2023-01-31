package com.abdulrahman.assignment18.advice;

import com.abdulrahman.assignment18.exception.ApiException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity ApiException(MethodArgumentNotValidException e){
        String message = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity ConstraintViolationException(ConstraintViolationException e){
//        String message = e.getMessage();
        return ResponseEntity.status(400).body("Wrong data");
    }
}

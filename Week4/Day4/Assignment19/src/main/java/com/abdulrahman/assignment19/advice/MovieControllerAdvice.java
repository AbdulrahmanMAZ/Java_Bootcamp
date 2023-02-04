package com.abdulrahman.assignment19.advice;

import com.abdulrahman.assignment19.exception.ApiException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieControllerAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    public ResponseEntity Exception(Exception e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = UnexpectedTypeException.class)
    public ResponseEntity MethodArgumentNotValidException(UnexpectedTypeException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
//        String message = e.getMessage();
        return ResponseEntity.status(400).body("You must enter a valid number");
    }

}

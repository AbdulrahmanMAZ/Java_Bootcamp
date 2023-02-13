package com.example.springsecurity.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}

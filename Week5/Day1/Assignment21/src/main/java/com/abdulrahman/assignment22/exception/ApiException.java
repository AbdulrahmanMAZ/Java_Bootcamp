package com.abdulrahman.assignment22.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}

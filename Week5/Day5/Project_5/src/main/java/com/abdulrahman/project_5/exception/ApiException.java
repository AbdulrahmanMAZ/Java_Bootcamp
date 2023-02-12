package com.abdulrahman.project_5.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}

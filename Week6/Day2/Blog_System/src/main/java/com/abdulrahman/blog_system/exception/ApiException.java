package com.abdulrahman.blog_system.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}

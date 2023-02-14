package com.abdulrahman.store.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}

package com.abdulrahman.exercise22.stores.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}

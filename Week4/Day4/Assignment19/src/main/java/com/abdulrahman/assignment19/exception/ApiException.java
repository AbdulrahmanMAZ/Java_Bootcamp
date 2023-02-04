package com.abdulrahman.assignment19.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}

package com.abdulrhamn.Assignment_18.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}

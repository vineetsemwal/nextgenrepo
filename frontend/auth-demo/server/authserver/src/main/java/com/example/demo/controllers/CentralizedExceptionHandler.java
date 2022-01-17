package com.example.demo.controllers;

import com.example.demo.exceptions.InvalidEmployeeCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidEmployeeCredentials.class)
    public String handleInvalidCredentials(InvalidEmployeeCredentials e){
        return e.getMessage();
    }

}

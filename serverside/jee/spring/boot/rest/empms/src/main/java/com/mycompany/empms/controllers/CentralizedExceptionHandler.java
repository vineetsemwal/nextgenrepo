package com.mycompany.empms.controllers;

import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import com.mycompany.empms.exceptions.InvalidEmployeeAgeException;
import com.mycompany.empms.exceptions.InvalidEmployeeIdException;
import com.mycompany.empms.exceptions.InvalidEmployeeNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException e) {
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidEmployeeNameException.class)
    public String handleInvalidEmployeeName(InvalidEmployeeNameException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidEmployeeAgeException.class)
    public String handleInvalidEmployeeAge(InvalidEmployeeAgeException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidEmployeeIdException.class)
    public String handleInvalidEmployeeId(InvalidEmployeeIdException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleInBlanketWay(Exception e) {
        return e.getMessage();
    }


}

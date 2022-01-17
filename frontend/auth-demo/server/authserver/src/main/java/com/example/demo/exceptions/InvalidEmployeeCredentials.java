package com.example.demo.exceptions;

public class InvalidEmployeeCredentials extends  RuntimeException{

    public  InvalidEmployeeCredentials(String msg){
        super(msg);
    }

}

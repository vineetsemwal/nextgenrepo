package com.example.demo.controllers;

import com.example.demo.dto.LoginRequestData;
import com.example.demo.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestData requestData){
     return authService.login(requestData);
    }

}

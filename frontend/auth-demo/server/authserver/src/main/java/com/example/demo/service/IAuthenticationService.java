package com.example.demo.service;

import com.example.demo.dto.LoginRequestData;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface IAuthenticationService {

   String login(@Valid @NotNull LoginRequestData requestData);

   void checkCredentialsByToken(String token);


}

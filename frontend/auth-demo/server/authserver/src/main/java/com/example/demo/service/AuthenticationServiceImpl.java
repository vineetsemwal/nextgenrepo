package com.example.demo.service;

import com.example.demo.dto.LoginRequestData;
import com.example.demo.dto.TokenData;
import com.example.demo.exceptions.InvalidEmployeeCredentials;
import com.example.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

    @Autowired
    private TokenUtil tokenUtil;
    @Value("${expectedUsername}")
    private String expectedUsername;
    @Value("${expectedPassword}")
    private String expectedPassword;

    @Override
    public String login(LoginRequestData requestData) {
        if(!expectedUsername.equals(requestData.getUsername()) || !expectedPassword.equals(requestData.getPassword())){
            throw new InvalidEmployeeCredentials("invalid creentials username="+requestData.getUsername() +" password="+requestData.getPassword());
        }

        return tokenUtil.generateToken(requestData.getUsername(), requestData.getPassword());
    }

    @Override
    public void checkCredentialsByToken(String tokenText) {
        if(tokenText==null || tokenText.isEmpty()){
            throw new InvalidEmployeeCredentials("token is null or empty");
        }
      TokenData token=tokenUtil.decodeToken(tokenText);
        if(!expectedUsername.equals(token.getUsername()) || !expectedPassword.equals(token.getPassword())){
            throw new InvalidEmployeeCredentials("invalid token="+tokenText);
        }

    }
}

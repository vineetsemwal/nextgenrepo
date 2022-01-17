package com.example.demo.util;

import com.example.demo.dto.TokenData;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    public String generateToken(String username, String password){
        return username+","+password;
    }

    public TokenData decodeToken(String tokenText){
       String parts[]= tokenText.split(",");
        TokenData token=new TokenData();
        token.setUsername(parts[0]);
        token.setPassword(parts[1]);
        return token;
      }

}

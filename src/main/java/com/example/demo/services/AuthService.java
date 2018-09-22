package com.example.demo.services;

import com.example.demo.daos.AuthDao;
import com.example.demo.daos.TokenDAO;
import com.example.demo.jpaEnities.Token;
import com.example.demo.jpaEnities.User;
import com.example.demo.pojos.Auth;
import com.example.demo.pojos.NewTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    @Qualifier("mySql")
    private AuthDao authDao;


    @Autowired
    @Qualifier("mySql")
    private TokenDAO tokenDao;

    public boolean authenticateUser(Auth user) {
        User userDetails = authDao.getUserDetails(user.getUsername());
        if (userDetails != null){
            return userDetails.getPassword().equals(user.getPassword());
        }
        return false;
    }

    public NewTokenResponse generateNewTokenForUser(String username) {
        //Get user details
        User user = authDao.getUserDetails(username);
        if (user != null){
            //Delete previous token if exists
            int response = tokenDao.deleteInvalidUserToken(user);

            //Generate token for 8 hours
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.HOUR_OF_DAY, 8);

            //Random guid for token
            UUID uuid = UUID.randomUUID();

            //Generate Token entity object
            Token token = new Token();
            token.setUser(user);
            token.setToken(uuid.toString());
            token.setExpirationDate(calendar.getTime());

            //Generated token response
            Token generateToken = tokenDao.generateNewTokenForUser(token);
            return new NewTokenResponse(generateToken.getToken(),generateToken.getExpirationDate(),username);
        }
        return new NewTokenResponse();
    }


    public Boolean validateToken(Auth userToken) {
        return tokenDao.validateToken(userToken);
    }
}

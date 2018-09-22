package com.example.demo.daos;

import com.example.demo.jpaEnities.Token;
import com.example.demo.jpaEnities.User;
import com.example.demo.pojos.Auth;
import com.example.demo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mySql")
public class TokenDAO {

    @Autowired
    private TokenRepository tokenRepository;

    public Token generateNewTokenForUser(Token token) {
        Token response = tokenRepository.save(token);
        return response;
    }

    public Boolean validateToken(Auth userToken) {
        Token returnedToken = tokenRepository.findByToken(userToken.getToken());
        if (returnedToken != null){
            if (returnedToken.getUser().getUsername().equals(userToken.getUsername())){
                if (returnedToken.getExpirationDate().getTime() > System.currentTimeMillis() ){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int deleteInvalidUserToken(User user) {
        return tokenRepository.deleteTokenByUser(user);
    }
}

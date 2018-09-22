package com.example.demo.daos;

import com.example.demo.jpaEnities.User;
import com.example.demo.repository.AuthRepository;
import com.example.demo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mySql")
public class AuthDao {

    @Autowired
    private AuthRepository authRepository;

    public User getUserDetails(String username) {
        return authRepository.findUserByUsername(username);
    }

}

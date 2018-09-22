package com.example.demo.repository;

import com.example.demo.jpaEnities.Token;
import com.example.demo.jpaEnities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    Token save(Token token);

    Token findByToken(String token);

    @Transactional
    int deleteTokenByUser(User user);
}

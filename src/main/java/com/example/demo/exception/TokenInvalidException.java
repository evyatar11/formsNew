package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TokenInvalidException extends RuntimeException {
    public TokenInvalidException(String userId) {
        super("Token expired or invalid, userid:  " + userId + "'.");
    }
}

package com.example.demo.controllers;

import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.services.LgdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LgdController {

    @Autowired
    LgdService lgdService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getForms" , method = RequestMethod.GET)
    public List<LgdQuestion> getLgdQuestions(/*@RequestHeader(value="username") String username, @RequestHeader(value="token") String token*/){
//        if (authService.validateToken(new Auth(username,token)))
            return lgdService.getLgdQuestions();
//        else
//            throw new TokenInvalidException(username);
    }


}

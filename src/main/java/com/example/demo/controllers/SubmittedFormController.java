package com.example.demo.controllers;

import com.example.demo.DTOs.SubmittedFormDTO;
import com.example.demo.exception.TokenInvalidException;
import com.example.demo.jpaEnities.FormSubmission;
import com.example.demo.jpaEnities.USPBpdConv;
import com.example.demo.pojos.Auth;
import com.example.demo.services.AuthService;
import com.example.demo.services.SubmittedFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/submittedForms")
public class SubmittedFormController {

    @Autowired
    private SubmittedFormService submittedFormService;

    @Autowired
    private AuthService authService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    public FormSubmission submitForm(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token,@RequestBody SubmittedFormDTO form){
        if (authService.validateToken(new Auth(username,token)))
            return submittedFormService.submitForm(form);
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getSubmittedForms", method = RequestMethod.GET)
    public List<FormSubmission> getSubmittedForms(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token){
        if (authService.validateToken(new Auth(username,token)))
            return submittedFormService.getSubmittedForms();
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteSubmittedFormById/{id}", method = RequestMethod.DELETE)
    public void deleteSubmittedFormById(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token,@PathVariable("id") int id){
        if (authService.validateToken(new Auth(username,token)))
            submittedFormService.deleteSubmittedFormById(id);
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getUpdatedPdAndRating/{score}", method = RequestMethod.GET)
    public USPBpdConv getUpdatedPdAndRating(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token,
                                            @PathVariable("score") double score){
        if (authService.validateToken(new Auth(username,token)))
            return submittedFormService.getUpdatedPdAndRating(score);
        else
            throw new TokenInvalidException(username);
    }

}

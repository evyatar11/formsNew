package com.example.demo.controllers;

import com.example.demo.exception.TokenInvalidException;
import com.example.demo.jpaEnities.BussinessUnit;
import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.pojos.Auth;
import com.example.demo.pojos.Borrower;
import com.example.demo.pojos.IBorrower;
import com.example.demo.services.AuthService;
import com.example.demo.services.LgdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/lgd")
public class LgdController {

    @Autowired
    LgdService lgdService;

    @Autowired
    AuthService authService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getBussinessUnits" , method = RequestMethod.GET)
    public List<BussinessUnit> getBussinessUnits(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token){
        if (authService.validateToken(new Auth(username,token)))
            return lgdService.getBussinessUnits();
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getLgdQuestions" , method = RequestMethod.GET)
    public List<LgdQuestion> getLgdQuestions(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token){
        if (authService.validateToken(new Auth(username,token)))
            return lgdService.getLgdQuestions();
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submit" , method = RequestMethod.POST)
    public DealScoreSubmission submit(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token,@RequestBody DealScoreSubmission submission){
        if (authService.validateToken(new Auth(username,token)))
            return lgdService.submit(submission);
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getSubmittedBorrowers" , method = RequestMethod.GET)
    public List<Borrower> getSubmittedBorrowers(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token){
        if (authService.validateToken(new Auth(username,token)))
            return lgdService.getSubmittedBorrowers();
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getBorrowerLoans/{borrowerId}/{borrowerName}" , method = RequestMethod.GET)
    public List<Integer> getBorrowerLoans(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token,
                                           @PathVariable("borrowerId") int borrowerId,@PathVariable("borrowerName") String borrowerName){
        if (authService.validateToken(new Auth(username,token)))
            return lgdService.getBorrowersLoans(borrowerId,borrowerName);
        else
            throw new TokenInvalidException(username);
    }



    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getLastSubmittedFromByBorrower/{borrowerId}/{borrowerName}" , method = RequestMethod.GET)
    public DealScoreSubmission getLastSubmittedFromByBorrower(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token,
                                                              @PathVariable("borrowerId") int borrowerId,@PathVariable("borrowerName") String borrowerName){
        if (authService.validateToken(new Auth(username,token)))
            return lgdService.getLastSubmittedFromByBorrower(borrowerId,borrowerName);
        else
            throw new TokenInvalidException(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getLastSubmittedFromByBorrowerAndLoan/{borrowerId}/{borrowerName}/{loanId}" , method = RequestMethod.GET)
    public DealScoreSubmission getLastSubmittedFromByBorrowerAndLoan(@RequestHeader(value="username") String username, @RequestHeader(value="token") String token,
                                                              @PathVariable("borrowerId") int borrowerId,@PathVariable("borrowerName") String borrowerName,
                                                              @PathVariable("loanId") int loanId){
        if (authService.validateToken(new Auth(username,token)))
        return lgdService.getLastSubmittedFromByBorrowerAndLoan(borrowerId,borrowerName,loanId);
        else
            throw new TokenInvalidException(username);
    }

}

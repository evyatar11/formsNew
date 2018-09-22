package com.example.demo.controllers;

import com.example.demo.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class LoggingController {

    @Autowired
    private LogService logService;

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/logSuccessfulLogin/{username}" , method = RequestMethod.GET)
    public void logSuccessfulLogin(@PathVariable("username") String username){
        logService.logSuccessfulLogin(username);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/logFailedLogin/{username}" , method = RequestMethod.GET)
    public void logFailedLogin(@PathVariable("username") String username){
        logService.logFailedLogin(username);
    }
}

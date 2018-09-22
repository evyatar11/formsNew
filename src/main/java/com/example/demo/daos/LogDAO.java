package com.example.demo.daos;

import com.example.demo.jpaEnities.Log;
import com.example.demo.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
@Qualifier("mySql")
public class LogDAO {

    @Autowired
    LogRepository logRepository;


    public void logFailedLogin(String username) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Log log = new Log();
        log.setUsername(username);
        log.setMessage("Sign in attempt failed");
        log.setDate(calendar.getTime());
        logRepository.save(log);
    }

    public void logSuccessfulLogin(String username) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Log log = new Log();
        log.setUsername(username);
        log.setMessage("Sign in attempt succeeded");
        log.setDate(calendar.getTime());
        logRepository.save(log);
    }
}

package com.example.demo.services;

import com.example.demo.daos.AuthDao;
import com.example.demo.daos.LogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    @Qualifier("mySql")
    private LogDAO logDao;

    public void logFailedLogin(String username) {
        logDao.logFailedLogin(username);
    }

    public void logSuccessfulLogin(String username) {
        logDao.logSuccessfulLogin(username);
    }
}

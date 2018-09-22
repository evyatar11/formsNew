package com.example.demo.services;

import com.example.demo.daos.LgdDAO;
import com.example.demo.jpaEnities.LgdQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LgdService {

    @Autowired
    LgdDAO lgdDao;

    public List<LgdQuestion> getLgdQuestions() {
        return lgdDao.getLgdQuestions();
    }
}

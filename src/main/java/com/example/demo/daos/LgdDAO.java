package com.example.demo.daos;


import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.repository.LgdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("mySql")
public class LgdDAO {

    @Autowired
    private LgdRepository lgdRepository;


    public List<LgdQuestion> getLgdQuestions() {
        return  lgdRepository.findAll();
    }
}

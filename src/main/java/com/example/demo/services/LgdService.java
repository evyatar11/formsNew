package com.example.demo.services;

import com.example.demo.daos.LgdDAO;
import com.example.demo.jpaEnities.BussinessUnit;
import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.pojos.Borrower;
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

    public List<BussinessUnit> getBussinessUnits() {
        return lgdDao.getBussinessUnits();
    }

    public DealScoreSubmission submit(DealScoreSubmission submission) {
        return lgdDao.submit(submission);
    }

    public List<DealScoreSubmission> getSubmittedBorrowers() {
        return lgdDao.getSubmittedBorrowers();
    }
}

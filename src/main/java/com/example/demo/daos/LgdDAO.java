package com.example.demo.daos;


import com.example.demo.jpaEnities.BussinessUnit;
import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.pojos.Borrower;
import com.example.demo.repository.BussinessUnitRepository;
import com.example.demo.repository.DealScoreSubmittionRepository;
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

    @Autowired
    private BussinessUnitRepository bussinessUnitRepository;

    @Autowired
    private DealScoreSubmittionRepository dealScoreSubmittionRepository;

    public List<LgdQuestion> getLgdQuestions() {
        return  lgdRepository.findAll();
    }

    public List<BussinessUnit> getBussinessUnits() {
        return bussinessUnitRepository.findAll();
    }

    public DealScoreSubmission submit(DealScoreSubmission submission) {
        return dealScoreSubmittionRepository.save(submission);
    }

    public List<Borrower> getSubmittedBorrowers() {
//        return dealScoreSubmittionRepository.getDistinctBorrowers();
        return null;
    }
}

package com.example.demo.daos;


import com.example.demo.jpaEnities.BussinessUnit;
import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.pojos.Borrower;
import com.example.demo.pojos.IBorrower;
import com.example.demo.repository.BussinessUnitRepository;
import com.example.demo.repository.DealScoreSubmittionRepository;
import com.example.demo.repository.LgdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
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
        List<Borrower> borrowers = new ArrayList<>();
        List<IBorrower> borrowersRaw = dealScoreSubmittionRepository.getDistinctBorrowers();
        for (IBorrower borrower: borrowersRaw) {
            borrowers.add(new Borrower(borrower.getBorrowerId(),borrower.getBorrowerName()));
        }
        Collections.sort(borrowers);
        return borrowers;
    }

    public DealScoreSubmission getLastSubmittedFromByBorrower(long borrowerId, String borrowerName) {
        return dealScoreSubmittionRepository.findTop1ByBorrowerIdAndBorrowerNameAndFormStatusNotLikeOrderByDateDesc(borrowerId,borrowerName,"draft");
    }

    public DealScoreSubmission getLastSubmittedFromByBorrowerAndLoan(long borrowerId, String borrowerName, long loanId) {
        return dealScoreSubmittionRepository.findTop1ByBorrowerIdAndBorrowerNameAndLoanIdAndFormStatusNotLikeOrderByDateDesc(borrowerId,borrowerName,loanId,"draft");
    }

    public List<BigInteger> getBorrowersLoans(long borrowerId, String borrowerName) {
        return dealScoreSubmittionRepository.getBorrowersLoansList(borrowerId,borrowerName);
    }

    public String getBorrowerNameById(long borrowerId) {
        return dealScoreSubmittionRepository.getBorrowerNameById(borrowerId);
    }

    public String getLoanNameById(long loanId) {
        return dealScoreSubmittionRepository.getLoanNameById(loanId);
    }
}

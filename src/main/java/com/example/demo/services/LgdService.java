package com.example.demo.services;

import com.example.demo.daos.LgdDAO;
import com.example.demo.jpaEnities.BussinessUnit;
import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.pojos.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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

    public List<Borrower> getSubmittedBorrowers() {
        return lgdDao.getSubmittedBorrowers();
    }

    public DealScoreSubmission getLastSubmittedFromByBorrower(long borrowerId, String borrowerName) {
        return lgdDao.getLastSubmittedFromByBorrower(borrowerId,borrowerName);
    }

    public DealScoreSubmission getLastSubmittedFromByBorrowerAndLoan(long borrowerId, String borrowerName, long loanId) {
        return lgdDao.getLastSubmittedFromByBorrowerAndLoan(borrowerId,borrowerName,loanId);
    }

    public List<BigInteger> getBorrowersLoans(long borrowerId, String borrowerName) {
        return lgdDao.getBorrowersLoans(borrowerId,borrowerName);
    }

    public String getBorrowerNameById(long borrowerId) {
        return lgdDao.getBorrowerNameById(borrowerId);
    }

    public String getLoanNameById(long loanId) {
        return lgdDao.getLoanNameById(loanId);
    }
}

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

import java.util.ArrayList;
import java.util.Collection;
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
        List<Borrower> borrowersWithLoans = new ArrayList<>();
        List<IBorrower> borrowersList = dealScoreSubmittionRepository.getDistinctBorrowers();
        for (IBorrower borrower: borrowersList) {
            List<Integer> borrowerLoans = dealScoreSubmittionRepository.getBorrowersLoans(borrower.getBorrowerId());
            borrowersWithLoans.add(new Borrower(borrower.getBorrowerId(),borrower.getBorrowerName(),borrowerLoans));
        }
        return borrowersWithLoans;
    }

    public DealScoreSubmission getLastSubmittedFromByBorrower(int borrowerId, String borrowerName) {
        return dealScoreSubmittionRepository.findTop1ByBorrowerIdAndBorrowerNameOrderByDateDesc(borrowerId,borrowerName);
    }

    public DealScoreSubmission getLastSubmittedFromByBorrowerAndLoan(int borrowerId, String borrowerName, int loanId) {
        return dealScoreSubmittionRepository.findTop1ByBorrowerIdAndBorrowerNameAndLoanIdOrderByDateDesc(borrowerId,borrowerName,loanId);
    }
}

package com.example.demo.pojos;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class Borrower {
    Integer borrowerId;
    String borrowerName;
    List<Integer> loans;

    public Borrower(Integer borrowerId, String borrowerName, List<Integer> loansList) {
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
        this.loans = loansList;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public List<Integer> getLoans() {
        return loans;
    }

    public void setLoans(List<Integer> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerId=" + borrowerId +
                ", borrowerName='" + borrowerName + '\'' +
                ", loans=" + loans +
                '}';
    }
}

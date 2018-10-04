package com.example.demo.pojos;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class Borrower implements Comparable<Borrower>{
    Long borrowerId;
    String borrowerName;
    List<Long> loans;

    public Borrower(Long borrowerId, String borrowerName) {
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
        this.loans = new ArrayList<Long>();
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public List<Long> getLoans() {
        return loans;
    }

    public void setLoans(List<Long> loans) {
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


    @Override
    public int compareTo(Borrower borrower) {
        return this.borrowerId.compareTo(borrower.borrowerId);
    }
}

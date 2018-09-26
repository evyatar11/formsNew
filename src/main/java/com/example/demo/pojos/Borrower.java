package com.example.demo.pojos;

import com.example.demo.jpaEnities.DealScoreSubmission;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

public class Borrower {

    private int borrowerId;
    private String borrowerName;

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Borrower(int borrowerId, String borrowerName) {
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
    }

    public Borrower() {
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerId=" + borrowerId +
                ", borrowerName='" + borrowerName + '\'' +
                '}';
    }

}

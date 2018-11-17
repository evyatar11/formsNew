package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Borrowers")
public class Borrower {

    @Id
    @GeneratedValue
    private Long id;
    private String borrowerName;

    @OneToMany(
            mappedBy = "borrower",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Loan> loans = new ArrayList<>();

    public Borrower() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long borrowerId) {
        this.id = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Borrowers{" +
                "Id=" +id +
                ", borrowerName='" + borrowerName + '\'' +
                '}';
    }
}

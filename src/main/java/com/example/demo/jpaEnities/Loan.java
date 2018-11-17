package com.example.demo.jpaEnities;

import javax.persistence.*;

@Entity
@Table(name = "Loans")
public class Loan {

    @Id
    @GeneratedValue
    private Long loanId;

    private String loanName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="borrower_id", nullable=false)
    private Borrower borrower;

    public Loan() {
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }
// Commented out because of an infinity loop bug when unCommented - //TODO investigate why ini loop happens
//    public Borrower getBorrower() {
//        return borrower;
//    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanName='" + loanName + '\'' +
                ", borrower=" + borrower +
                '}';
    }
}

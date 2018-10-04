package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DealScoreSubmissions")
public class DealScoreSubmission {
    @GeneratedValue()
    @Id
    private int id;
    private String ratedBy;
    @Column(name="borrowerId")
    private long borrowerId;
    @Column(name="borrowerName")
    private String borrowerName;
    private boolean crossCollaterlized;
    private long loanId;
    private String loanName;
    private String lendingOfficer;
    private long committeeId;
    private String businessUnit;
    private String currency;
    @Basic
    private java.sql.Timestamp date;
    @Lob
    @Column
    private String qa;
    private double ead;
    private double cashAndSecurities;
    private double baseLgd;
    private double modifiedLgd;
    private double adjustedLgd;
    private double finalLgd;
    private double overrideLgd;
    private String overrideReason;
    private String formStatus;

    public DealScoreSubmission() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(String ratedBy) {
        this.ratedBy = ratedBy;
    }

    public long getBorrowerId() {
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

    public boolean isCrossCollaterlized() {
        return crossCollaterlized;
    }

    public void setCrossCollaterlized(boolean crossCollaterlized) {
        this.crossCollaterlized = crossCollaterlized;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLendingOfficer() {
        return lendingOfficer;
    }

    public void setLendingOfficer(String lendingOfficer) {
        this.lendingOfficer = lendingOfficer;
    }

    public long getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(long committeeId) {
        this.committeeId = committeeId;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getQa() {
        return qa;
    }

    public void setQa(String qa) {
        this.qa = qa;
    }

    public double getEad() {
        return ead;
    }

    public void setEad(double ead) {
        this.ead = ead;
    }

    public double getCashAndSecurities() {
        return cashAndSecurities;
    }

    public void setCashAndSecurities(double cashAndSecurities) {
        this.cashAndSecurities = cashAndSecurities;
    }

    public double getBaseLgd() {
        return baseLgd;
    }

    public void setBaseLgd(double baseLgd) {
        this.baseLgd = baseLgd;
    }

    public double getModifiedLgd() {
        return modifiedLgd;
    }

    public void setModifiedLgd(double modifiedLgd) {
        this.modifiedLgd = modifiedLgd;
    }

    public double getAdjustedLgd() {
        return adjustedLgd;
    }

    public void setAdjustedLgd(double adjustedLgd) {
        this.adjustedLgd = adjustedLgd;
    }

    public double getFinalLgd() {
        return finalLgd;
    }

    public void setFinalLgd(double finalLgd) {
        this.finalLgd = finalLgd;
    }

    public double getOverrideLgd() {
        return overrideLgd;
    }

    public void setOverrideLgd(double overrideLgd) {
        this.overrideLgd = overrideLgd;
    }

    public String getOverrideReason() {
        return overrideReason;
    }

    public void setOverrideReason(String overrideReason) {
        this.overrideReason = overrideReason;
    }

    public String getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(String formStatus) {
        this.formStatus = formStatus;
    }

    @Override
    public String toString() {
        return "DealScoreSubmission{" +
                "id=" + id +
                ", ratedBy='" + ratedBy + '\'' +
                ", borrowerId=" + borrowerId +
                ", borrowerName='" + borrowerName + '\'' +
                ", crossCollaterlized=" + crossCollaterlized +
                ", loanId=" + loanId +
                ", loanName='" + loanName + '\'' +
                ", lendingOfficer='" + lendingOfficer + '\'' +
                ", committeeId=" + committeeId +
                ", businessUnit='" + businessUnit + '\'' +
                ", currency='" + currency + '\'' +
                ", date=" + date +
                ", qa='" + qa + '\'' +
                ", ead=" + ead +
                ", cashAndSecurities=" + cashAndSecurities +
                ", baseLgd=" + baseLgd +
                ", modifiedLgd=" + modifiedLgd +
                ", adjustedLgd=" + adjustedLgd +
                ", finalLgd=" + finalLgd +
                ", overrideLgd=" + overrideLgd +
                ", overrideReason='" + overrideReason + '\'' +
                ", formStatus='" + formStatus + '\'' +
                '}';
    }
}

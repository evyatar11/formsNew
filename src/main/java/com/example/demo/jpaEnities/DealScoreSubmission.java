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
    private int borrowerId;
    @Column(name="borrowerName")
    private String borrowerName;
    private boolean crossCollaterlized;
    private int loanId;
    private String loanName;
    private String lendingOfficer;
    private int committeeId;
    private String businessUnit;
    private String currency;
    @Basic
    private java.sql.Timestamp date;
    @Lob
    @Column
    private String qa;
    private int ead;
    private int cashAndSecurities;
    private int baseLgd;
    private int modifiedLgd;
    private int adjustedLgd;
    private int finalLgd;
    private int overrideLgd;
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

    public boolean isCrossCollaterlized() {
        return crossCollaterlized;
    }

    public void setCrossCollaterlized(boolean crossCollaterlized) {
        this.crossCollaterlized = crossCollaterlized;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
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

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
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

    public int getEad() {
        return ead;
    }

    public void setEad(int ead) {
        this.ead = ead;
    }

    public int getCashAndSecurities() {
        return cashAndSecurities;
    }

    public void setCashAndSecurities(int cashAndSecurities) {
        this.cashAndSecurities = cashAndSecurities;
    }

    public int getBaseLgd() {
        return baseLgd;
    }

    public void setBaseLgd(int baseLgd) {
        this.baseLgd = baseLgd;
    }

    public int getModifiedLgd() {
        return modifiedLgd;
    }

    public void setModifiedLgd(int modifiedLgd) {
        this.modifiedLgd = modifiedLgd;
    }

    public int getAdjustedLgd() {
        return adjustedLgd;
    }

    public void setAdjustedLgd(int adjustedLgd) {
        this.adjustedLgd = adjustedLgd;
    }

    public int getFinalLgd() {
        return finalLgd;
    }

    public void setFinalLgd(int finalLgd) {
        this.finalLgd = finalLgd;
    }

    public int getOverrideLgd() {
        return overrideLgd;
    }

    public void setOverrideLgd(int overrideLgd) {
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

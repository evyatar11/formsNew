package com.example.demo.pojos;

import com.google.gson.JsonObject;

public class FormSubmissionPojo {

    private int id;

    private String accountOfficeName;

    private String customerName;

    private double borrowerRating;

    private double pdScore;

    private SubmittedFormRawData submittedFormRawData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountOfficeName() {
        return accountOfficeName;
    }

    public void setAccountOfficeName(String accountOfficeName) {
        this.accountOfficeName = accountOfficeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBorrowerRating() {
        return borrowerRating;
    }

    public void setBorrowerRating(double borrowerRating) {
        this.borrowerRating = borrowerRating;
    }

    public double getPdScore() {
        return pdScore;
    }

    public void setPdScore(double pdScore) {
        this.pdScore = pdScore;
    }

    public SubmittedFormRawData getSubmittedFormRawData() {
        return submittedFormRawData;
    }

    public void setSubmittedFormRawData(SubmittedFormRawData submittedFormRawData) {
        this.submittedFormRawData = submittedFormRawData;
    }

    @Override
    public String toString() {
        return "FormSubmission{" +
                "id=" + id +
                ", accountOfficeName='" + accountOfficeName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", borrowerRating=" + borrowerRating +
                ", pdScore=" + pdScore +
                ", submittedFormRawData=" + submittedFormRawData +
                '}';
    }
}


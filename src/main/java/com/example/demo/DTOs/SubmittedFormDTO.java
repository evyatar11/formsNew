
package com.example.demo.DTOs;

import com.example.demo.pojos.SubmittedFormRawData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubmittedFormDTO {

    @SerializedName("accountOfficeName")
    @Expose
    private String accountOfficeName;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("borrowerRating")
    @Expose
    private String borrowerRating;
    @SerializedName("pdScore")
    @Expose
    private String pdScore;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("updatedRating")
    @Expose
    private String updatedRating;
    @SerializedName("submittedFormRawData")
    @Expose
    private SubmittedFormRawData submittedFormRawData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubmittedFormDTO() {
    }

    /**
     * 
     * @param borrowerRating
     * @param customerName
     * @param submittedFormRawData
     * @param accountOfficeName
     * @param pdScore
     */
    public SubmittedFormDTO(String accountOfficeName, String customerName, String borrowerRating, String pdScore, SubmittedFormRawData submittedFormRawData) {
        super();
        this.accountOfficeName = accountOfficeName;
        this.customerName = customerName;
        this.borrowerRating = borrowerRating;
        this.pdScore = pdScore;
        this.submittedFormRawData = submittedFormRawData;
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

    public String getBorrowerRating() {
        return borrowerRating;
    }

    public void setBorrowerRating(String borrowerRating) {
        this.borrowerRating = borrowerRating;
    }

    public String getPdScore() {
        return pdScore;
    }

    public void setPdScore(String pdScore) {
        this.pdScore = pdScore;
    }

    public SubmittedFormRawData getSubmittedFormRawData() {
        return submittedFormRawData;
    }

    public void setSubmittedFormRawData(SubmittedFormRawData submittedFormRawData) {
        this.submittedFormRawData = submittedFormRawData;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUpdatedRating() {
        return updatedRating;
    }

    public void setUpdatedRating(String updatedRating) {
        this.updatedRating = updatedRating;
    }
}

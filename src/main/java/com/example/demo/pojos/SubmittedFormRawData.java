
package com.example.demo.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubmittedFormRawData {

    @SerializedName("accountOfficeName")
    @Expose
    private String accountOfficeName;
    @SerializedName("borrowerRating")
    @Expose
    private String borrowerRating;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("pdScore")
    @Expose
    private String pdScore;
    @SerializedName("qa")
    @Expose
    private List<Qa> qa = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubmittedFormRawData() {
    }

    /**
     * 
     * @param qa
     */
    public SubmittedFormRawData(List<Qa> qa) {
        super();
        this.qa = qa;
    }

    public SubmittedFormRawData(String accountOfficeName, String borrowerRating, String customerName, String pdScore, List<Qa> qa) {
        this.accountOfficeName = accountOfficeName;
        this.borrowerRating = borrowerRating;
        this.customerName = customerName;
        this.pdScore = pdScore;
        this.qa = qa;
    }

    public List<Qa> getQa() {
        return qa;
    }

    public void setQa(List<Qa> qa) {
        this.qa = qa;
    }

    public String getAccountOfficeName() {
        return accountOfficeName;
    }

    public void setAccountOfficeName(String accountOfficeName) {
        this.accountOfficeName = accountOfficeName;
    }

    public String getBorrowerRating() {
        return borrowerRating;
    }

    public void setBorrowerRating(String borrowerRating) {
        this.borrowerRating = borrowerRating;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPdScore() {
        return pdScore;
    }

    public void setPdScore(String pdScore) {
        this.pdScore = pdScore;
    }
}

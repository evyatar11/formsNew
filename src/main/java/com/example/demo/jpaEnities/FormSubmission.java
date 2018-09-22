package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "SubmittedForms")
public class FormSubmission {
    @Id
    @GeneratedValue()
    @Column(name="id")
    private int id;

    private String accountOfficeName;

    private String customerName;

    private double borrowerRating;

    private double pdScore;

    @Basic
    private java.sql.Timestamp sqlTimestamp;

    @Lob
    @Column
    private String submittedFormRawData;

    public FormSubmission(){}//No argument constructor for JPA

    public Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    public void setSqlTimestamp(Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }

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

    public String getSubmittedFormRawData() {
        return submittedFormRawData;
    }

    public void setSubmittedFormRawData(String submittedFormRawData) {
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
                ", sqlTimestamp=" + sqlTimestamp +
                ", submittedFormRawData='" + submittedFormRawData + '\'' +
                '}';
    }
}

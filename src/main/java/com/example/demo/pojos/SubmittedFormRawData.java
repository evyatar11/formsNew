
package com.example.demo.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubmittedFormRawData {

    @SerializedName("submittedFormRawData")
    @Expose
    private SubmittedFormRawData_ submittedFormRawData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubmittedFormRawData() {
    }

    /**
     * 
     * @param submittedFormRawData
     */
    public SubmittedFormRawData(SubmittedFormRawData_ submittedFormRawData) {
        super();
        this.submittedFormRawData = submittedFormRawData;
    }

    public SubmittedFormRawData_ getSubmittedFormRawData() {
        return submittedFormRawData;
    }

    public void setSubmittedFormRawData(SubmittedFormRawData_ submittedFormRawData) {
        this.submittedFormRawData = submittedFormRawData;
    }

}

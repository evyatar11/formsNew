
package com.example.demo.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qa {

    @SerializedName("questionText")
    @Expose
    private String questionText;
    @SerializedName("answerText")
    @Expose
    private String answerText;
    @SerializedName("accountOfficeName")
    @Expose
    private String accountOfficeName;


    /**
     * No args constructor for use in serialization
     * 
     */ private Qa() {
    }

    /**
     * 
     * @param answerText
     * @param questionText
     */
    public Qa(String accountOfficeName,String questionText, String answerText) {
        super();
        this.questionText = questionText;
        this.answerText = answerText;
        this.accountOfficeName = accountOfficeName;

    }

    public String getaccountOfficeName() {
        return accountOfficeName;
    }

    public void setaccountOfficeName(String accountOfficeName) {
        this.accountOfficeName = accountOfficeName;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}

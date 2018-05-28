
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

    /**
     * No args constructor for use in serialization
     * 
     */
    public Qa() {
    }

    /**
     * 
     * @param answerText
     * @param questionText
     */
    public Qa(String questionText, String answerText) {
        super();
        this.questionText = questionText;
        this.answerText = answerText;
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

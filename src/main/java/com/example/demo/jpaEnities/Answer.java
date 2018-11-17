package com.example.demo.jpaEnities;

import javax.persistence.*;

@Entity
@Table(name = "USPBAnswers")
public class Answer {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int answerId;
    private int questionId;
    private String answerContent;
    private int answerScore;

    public Answer(){}//No argument constructor for JPA

    public Answer(int answerId, int questionId, String answerContent, int answerScore) {
        super();
        this.answerId = answerId;
        this.questionId = questionId;
        this.answerContent = answerContent;
        this.answerScore = answerScore;
    }

    public int getAnswerId() {
        return answerId;
    }
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getAnswerContent() {
        return answerContent;
    }
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
    public int getAnswerScore() {
        return answerScore;
    }
    public void setAnswerScore(int answerScore) {
        this.answerScore = answerScore;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", questionId=" + questionId +
                ", answerContent='" + answerContent + '\'' +
                ", answerScore=" + answerScore +
                '}';
    }

}

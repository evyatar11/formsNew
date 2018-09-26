package com.example.demo.jpaEnities;

import javax.persistence.*;

@Entity
@Table(name = "LgdAnswers")
public class LgdAnswer {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int answerId;
    private int questionId;
    private String answerContent;
    private int answerScore;
    @Column(name="Weight")
    private double weight;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LgdAnswer() {
    }

    @Override
    public String toString() {
        return "LgdAnswer{" +
                "answerId=" + answerId +
                ", questionId=" + questionId +
                ", answerContent='" + answerContent + '\'' +
                ", answerScore=" + answerScore +
                ", weight=" + weight +
                '}';
    }
}

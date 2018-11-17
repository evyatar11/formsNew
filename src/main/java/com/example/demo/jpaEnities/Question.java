package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USPBQuestions")
public class Question {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int questionId;
    private String questionContent;
    private double questionWeight;
    private int categoryId;

    @OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL)
    private List<Answer> answerList;

    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getQuestionContent() {
        return questionContent;
    }
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
    public double getQuestionWeight() {
        return questionWeight;
    }
    public void setQuestionWeight(double questionWeight) {
        this.questionWeight = questionWeight;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Question() {}

    public Question(int questionId, String questionContent, double questionWeight, int categoryId,List<Answer> answerList) {
        super();
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.questionWeight = questionWeight;
        this.categoryId = categoryId;
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionContent='" + questionContent + '\'' +
                ", questionWeight=" + questionWeight +
                ", categoryId=" + categoryId +
                ", answerList=" + answerList +
                '}';
    }

}

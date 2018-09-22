package com.example.demo.jpaEnities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LgdQuestions")
public class LgdQuestion {
    @Id
    @GeneratedValue
    @Column(name="questionId")
    private int id;
    private String questionContent;

    @OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL)
    private List<LgdAnswer> answerList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<LgdAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<LgdAnswer> answerList) {
        this.answerList = answerList;
    }

    public LgdQuestion() {
    }

    @Override
    public String toString() {
        return "LgdQuestion{" +
                "id=" + id +
                ", questionContent='" + questionContent + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}

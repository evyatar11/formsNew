package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USPBCategories")
public class Category {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int categoryId;
    @Column(name="categoryWeight")
    private double categoryWeight;
    @Column(name="categoryName")
    private String categoryName;
    @Column(name="formId")
    private int formId;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private List<Question> questionList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getCategoryWeight() {
        return categoryWeight;
    }

    public void setCategoryWeight(double categoryWeight) {
        this.categoryWeight = categoryWeight;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Category() {
    }

    public Category(int categoryId, int categoryWeight, String categoryName, int formId,List<Question> questionList) {
        super();
        this.categoryId = categoryId;
        this.categoryWeight = categoryWeight;
        this.categoryName = categoryName;
        this.formId = formId;
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryWeight=" + categoryWeight +
                ", categoryName='" + categoryName + '\'' +
                ", formId=" + formId +
                ", questionList=" + questionList +
                '}';
    }

}

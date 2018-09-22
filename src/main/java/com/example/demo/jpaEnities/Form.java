package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Forms")
public class Form {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int formId;
    @Column(name="formName")
    private String formName;

    @OneToMany(mappedBy = "formId", cascade = CascadeType.ALL)
    private List<Category> categoriesList;

    public Form(){}//No argument constructor for JPA

    public Form(int formId, String formName,List<Category> categoriesList) {
        super();
        this.formId = formId;
        this.formName = formName;
        this.categoriesList = categoriesList;
    }

    public int getFormId() {
        return formId;
    }
    public void setFormId(int formId) {
        this.formId = formId;
    }
    public String getFormName() {
        return formName;
    }
    public void setFormName(String formName) {
        this.formName = formName;
    }
    public List<Category> getCategoriesList() {
        return categoriesList;
    }
    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @Override
    public String toString() {
        return "Form{" +
                "formId=" + formId +
                ", formName='" + formName + '\'' +
                ", categoriesList=" + categoriesList +
                '}';
    }

    public String toHtmlString(){
        String html = "";
        for (Category category:categoriesList) {
            html += category.toHtmlString();
        }
        return html;
    }

}

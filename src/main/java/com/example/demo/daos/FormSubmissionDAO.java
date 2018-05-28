package com.example.demo.daos;


import com.example.demo.jpaEnities.FormSubmission;
import com.example.demo.pojos.FormSubmissionPojo;
import com.example.demo.repository.FormSubmissionRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("mySql")
public class FormSubmissionDAO {

    @Autowired
    private FormSubmissionRepository formSubmissionRepository;

    public FormSubmission submitForm(FormSubmissionPojo form) {
        Gson gson = new Gson();
        FormSubmission tempForm = new FormSubmission();
        tempForm.setAccountOfficeName(form.getAccountOfficeName());
        tempForm.setBorrowerRating(form.getBorrowerRating());
        tempForm.setCustomerName(form.getCustomerName());
        tempForm.setPdScore(form.getPdScore());
        System.out.println(form.toString());
        String jsonString = gson.toJson(form.getSubmittedFormRawData());
        tempForm.setSubmittedFormRawData(jsonString);
        return formSubmissionRepository.save(tempForm);
    }

    public List<FormSubmission> getSubmittedForms() {
        return formSubmissionRepository.findAll();
    }

    public List<FormSubmission> getSubmittedFormsByPdScore(double borrowerRating) {
        return formSubmissionRepository.findFormSubmissionByBorrowerRatingOrderByPdScoreDesc(borrowerRating);
    }
}

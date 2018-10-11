package com.example.demo.services;

import com.example.demo.DTOs.SubmittedFormDTO;
import com.example.demo.daos.FormSubmissionDAO;
import com.example.demo.jpaEnities.FormSubmission;
import com.example.demo.jpaEnities.USPBpdConv;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SubmittedFormService {

    @Autowired
	@Qualifier("mySql")
	private FormSubmissionDAO formSubmissionDao;

    public FormSubmission submitForm(SubmittedFormDTO form) {
        Gson gson = new Gson();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FormSubmission tempForm = new FormSubmission();
        tempForm.setAccountOfficeName(form.getAccountOfficeName());
        tempForm.setBorrowerRating(Double.valueOf(form.getBorrowerRating()));
        tempForm.setCustomerName(form.getCustomerName());
        tempForm.setScore(Double.valueOf(form.getScore()));
        tempForm.setPdScore(Double.valueOf(form.getPdScore()));
        tempForm.setUpdatedRating(Double.valueOf(form.getUpdatedRating()));
        tempForm.setSqlTimestamp(timestamp);
        String jsonString = gson.toJson(form.getSubmittedFormRawData());
        System.out.println("JsonString: " + jsonString);
        tempForm.setSubmittedFormRawData(jsonString);
        return formSubmissionDao.submitForm(tempForm);
    }

    public List<FormSubmission> getSubmittedForms() {
		return formSubmissionDao.getSubmittedForms();
    }

    public List<FormSubmission> getSubmittedFormsByBorrowerRating(double borrowerRating) {
		return formSubmissionDao.getSubmittedFormsByPdScore(borrowerRating);
    }

    public void deleteSubmittedFormById(int id) {
        formSubmissionDao.deleteSubmittedFormById(id);
    }

    public USPBpdConv getUpdatedPdAndRating(double score) {
        return formSubmissionDao.getUpdatedPdAndRating(score);
    }
}

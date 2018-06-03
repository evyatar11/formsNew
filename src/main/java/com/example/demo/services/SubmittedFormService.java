package com.example.demo.services;

import com.example.demo.DTOs.SubmittedFormDTO;
import com.example.demo.daos.FormSubmissionDAO;
import com.example.demo.jpaEnities.FormSubmission;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubmittedFormService {

    @Autowired
	@Qualifier("mySql")
	private FormSubmissionDAO formSubmissionDao;

    public FormSubmission submitForm(SubmittedFormDTO form) {
        Gson gson = new Gson();
        FormSubmission tempForm = new FormSubmission();
        tempForm.setAccountOfficeName(form.getAccountOfficeName());
        tempForm.setBorrowerRating(Double.valueOf(form.getBorrowerRating()));
        tempForm.setCustomerName(form.getCustomerName());
        tempForm.setPdScore(Double.valueOf(form.getPdScore()));
     // tempForm.setModifiedTimestamp(calendar.getTime());
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
}

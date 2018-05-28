package com.example.demo.services;

import com.example.demo.daos.FormSubmissionDAO;
import com.example.demo.jpaEnities.FormSubmission;
import com.example.demo.pojos.FormSubmissionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmittedFormService {

    @Autowired
	@Qualifier("mySql")
	private FormSubmissionDAO formSubmissionDao;

    public FormSubmission submitForm(FormSubmissionPojo form) {
		return formSubmissionDao.submitForm(form);
    }

    public List<FormSubmission> getSubmittedForms() {
		return formSubmissionDao.getSubmittedForms();
    }

    public List<FormSubmission> getSubmittedFormsByBorrowerRating(double borrowerRating) {
		return formSubmissionDao.getSubmittedFormsByPdScore(borrowerRating);
    }
}

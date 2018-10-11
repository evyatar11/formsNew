package com.example.demo.daos;


import com.example.demo.jpaEnities.FormSubmission;
import com.example.demo.jpaEnities.USPBpdConv;
import com.example.demo.repository.FormSubmissionRepository;
import com.example.demo.repository.PdConvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("mySql")
public class FormSubmissionDAO {

    @Autowired
    private FormSubmissionRepository formSubmissionRepository;

    @Autowired
    private PdConvRepository pdConvRepository;

    public FormSubmission submitForm(FormSubmission form) {
        return formSubmissionRepository.save(form);
    }

    public List<FormSubmission> getSubmittedForms() {
        return formSubmissionRepository.findAll();
    }

    public List<FormSubmission> getSubmittedFormsByPdScore(double borrowerRating) {
        return formSubmissionRepository.findFormSubmissionByBorrowerRatingOrderByScoreDesc(borrowerRating);
    }

    public void deleteSubmittedFormById(int id) {
        formSubmissionRepository.deleteById(id);
    }

    public USPBpdConv getUpdatedPdAndRating(double score) {
        return pdConvRepository.getUpdatedPdAndRating(score);
    }
}

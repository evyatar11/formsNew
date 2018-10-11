package com.example.demo.repository;

import com.example.demo.jpaEnities.FormSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormSubmissionRepository extends JpaRepository<FormSubmission, Integer> {
    List<FormSubmission> findFormSubmissionByBorrowerRatingOrderByScoreDesc(Double borrowerRating);
}

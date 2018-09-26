package com.example.demo.repository;

import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.pojos.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DealScoreSubmittionRepository extends JpaRepository<DealScoreSubmission, Integer> {


//    @Query("SELECT distinct borrowerId,borrowerName FROM DealScoreSubmissions")
//    List<DealScoreSubmission> getDistinctBorrowers();

}

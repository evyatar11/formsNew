package com.example.demo.repository;

import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.pojos.IBorrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface DealScoreSubmittionRepository extends JpaRepository<DealScoreSubmission, Integer> {

    @Query(value = "SELECT distinct borrowerId,borrowerName FROM DealScoreSubmissions",nativeQuery = true)
    List<IBorrower> getDistinctBorrowers();

    @Query (value = "select distinct loanId FROM DealScoreSubmissions where crossCollaterlized = 0 and borrowerId = :id",nativeQuery = true)
    List<Integer> getBorrowersLoans(@Param("id") int borrowerId);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameOrderByDateDesc(Integer borrowerId,String borrowerName);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameAndLoanIdOrderByDateDesc(Integer borrowerId,String borrowerName,Integer loanId);

    @Query (value = "select distinct loanId FROM DealScoreSubmissions where crossCollaterlized = 0 and borrowerId = :id and borrowerName = :name",nativeQuery = true)
    List<Integer> getBorrowersLoansList(@Param("id") int borrowerId ,@Param("name") String borrowerName);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameAndFormStatusNotLikeOrderByDateDesc(Integer borrowerId,String borrowerName,String draftString);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameAndLoanIdAndFormStatusNotLikeOrderByDateDesc(Integer borrowerId,String borrowerName,Integer loanId,String draftString);


}

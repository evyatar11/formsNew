package com.example.demo.repository;

import com.example.demo.jpaEnities.DealScoreSubmission;
import com.example.demo.pojos.IBorrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Transactional
@Repository
public interface DealScoreSubmittionRepository extends JpaRepository<DealScoreSubmission, Integer> {

    @Query(value = "SELECT distinct borrowerId,borrowerName FROM DealScoreSubmissions",nativeQuery = true)
    List<IBorrower> getDistinctBorrowers();

    @Query (value = "select distinct loanId FROM DealScoreSubmissions where crossCollaterlized = 0 and borrowerId = :id",nativeQuery = true)
    List<Long> getBorrowersLoans(@Param("id") long borrowerId);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameOrderByDateDesc(Long borrowerId,String borrowerName);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameAndLoanIdOrderByDateDesc(Long borrowerId,String borrowerName,Long loanId);

    @Query (value = "select distinct loanId FROM DealScoreSubmissions where crossCollaterlized = 0 and borrowerId = :id and borrowerName = :name",nativeQuery = true)
    List<BigInteger> getBorrowersLoansList(@Param("id") long borrowerId , @Param("name") String borrowerName);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameAndFormStatusNotLikeOrderByDateDesc(Long borrowerId,String borrowerName,String draftString);

    DealScoreSubmission findTop1ByBorrowerIdAndBorrowerNameAndLoanIdAndFormStatusNotLikeOrderByDateDesc(Long borrowerId,String borrowerName,Long loanId,String draftString);

    @Query (value = "select distinct borrowerName FROM DealScoreSubmissions where borrowerId = :id ",nativeQuery = true)
    String getBorrowerNameById(@Param("id") long borrowerId);

    @Query (value = "select distinct loanName FROM DealScoreSubmissions where loanId = :id ",nativeQuery = true)
    String getLoanNameById(@Param("id") long loanId);
}

package com.example.demo.repository;

import com.example.demo.jpaEnities.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
    Borrower findById (Long id);
}
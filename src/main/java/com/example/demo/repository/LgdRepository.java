package com.example.demo.repository;

import com.example.demo.jpaEnities.LgdQuestion;
import com.example.demo.pojos.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LgdRepository extends JpaRepository<LgdQuestion, Integer> {


}

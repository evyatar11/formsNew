package com.example.demo.repository;

import com.example.demo.jpaEnities.LgdQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LgdRepository extends JpaRepository<LgdQuestion, Integer> {


}

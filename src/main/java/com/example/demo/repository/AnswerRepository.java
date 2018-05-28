package com.example.demo.repository;

import com.example.demo.jpaEnities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AnswerRepository  extends JpaRepository<Answer, Integer> {
    Collection<Answer> findAnswerByAnswerId(Integer id);
    Collection<Answer> findAnswerByQuestionId(Integer id);
}
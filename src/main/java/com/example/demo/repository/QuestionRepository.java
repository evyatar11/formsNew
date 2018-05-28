package com.example.demo.repository;

import com.example.demo.jpaEnities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Collection<Question> findQuestionByQuestionId(Integer id);
    Collection<Question> findQuestionsByQuestionContent(String content);
    Collection<Question> findQuestionByCategoryId(Integer id);
}

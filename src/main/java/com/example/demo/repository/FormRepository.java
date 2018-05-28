package com.example.demo.repository;

import com.example.demo.jpaEnities.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface FormRepository extends JpaRepository<Form, Integer> {
    Form findFormByFormId(Integer id);
    Form findFormByFormName(String formName);
}
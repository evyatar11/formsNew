package com.example.demo.daos;

import java.util.List;

import com.example.demo.jpaEnities.Form;
import com.example.demo.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mySql")
public class FormDAO {

	@Autowired
	private FormRepository formRepository;

	public List<Form> getForms() {
		return formRepository.findAll();
	}

	public Form getFormById(Integer formId){
		return formRepository.findFormByFormId(formId);
	}
}

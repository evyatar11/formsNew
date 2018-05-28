package com.example.demo.services;

import java.util.List;
import com.example.demo.daos.FormDAO;
import com.example.demo.jpaEnities.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FormService {
	@Autowired
	@Qualifier("mySql")
	private FormDAO formDao;

	public List<Form> getForms(){
		return formDao.getForms();
	}

	public String getFormDataHtml(Integer formId){
		Form form = formDao.getFormById(formId);
		return form.toHtmlString();
	}

}

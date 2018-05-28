package com.example.demo.controllers;

import java.util.List;
import com.example.demo.jpaEnities.Form;
import com.example.demo.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forms")
public class FormController {
	@Autowired
	private FormService formService;

	@RequestMapping(value = "/{formId}" , method = RequestMethod.GET)
	public String getFormData(@PathVariable("formId") int formId){
		return formService.getFormDataHtml(formId);
	}

	@RequestMapping(value = "/getForms" , method = RequestMethod.GET)
	public List<Form> getForms(){
		return formService.getForms();
	}

}

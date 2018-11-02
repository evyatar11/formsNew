package com.example.demo.controllers;

import java.util.List;
import com.example.demo.exception.TokenInvalidException;
import com.example.demo.jpaEnities.Form;
import com.example.demo.pojos.Auth;
import com.example.demo.pojos.NewTokenResponse;
import com.example.demo.services.AuthService;
import com.example.demo.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forms")
public class FormController {
	@Autowired
	private FormService formService;

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/{formId}" , method = RequestMethod.GET)
	public String getFormData(@RequestHeader(value="token") NewTokenResponse token, @PathVariable("formId") int formId){
		return formService.getFormDataHtml(formId);
	}

	@RequestMapping(value = "/getForms" , method = RequestMethod.GET)
	public List<Form> getForms(@RequestHeader(value="username") String username,@RequestHeader(value="token") String token){
		if (authService.validateToken(new Auth(username,token)))
			return formService.getForms();
		else
			throw new TokenInvalidException(username);
	}

	@RequestMapping(value = "/getFormData/{formId}" , method = RequestMethod.GET)
	public Form getFormDataById(@PathVariable("formId") int formId){
		return formService.getFormDataById(formId);
	}

}

package com.example.demo.controllers;

import java.util.List;
import com.example.demo.exception.TokenInvalidException;
import com.example.demo.jpaEnities.Borrower;
import com.example.demo.jpaEnities.Form;
import com.example.demo.jpaEnities.Prospect;
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


	@RequestMapping(value = "/getAllBorrowers",method = RequestMethod.GET)
	public List<Borrower> getAllBorrowers(){
		return formService.getAllBorrowers();
	}

	@RequestMapping(value = "/getBorrowersById/{borrowerId}",method = RequestMethod.GET)
	public Borrower getBorrowersById(@PathVariable("borrowerId") Long borrowerId){
		return formService.getBorrowersById(borrowerId);
	}

	@RequestMapping(value = "/getAllProspects",method = RequestMethod.GET)
	public List<Prospect> getAllProspects(){
		return formService.getAllProspects();
	}

	@RequestMapping(value = "/getProspectCreatorId/{userId}",method = RequestMethod.GET)
	public Prospect getProspectByCreatingUserId(@PathVariable("userId") Long userId){
		return formService.getProspectByCreatingUserId(userId);
	}
}

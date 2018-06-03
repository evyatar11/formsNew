package com.example.demo.controllers;

import com.example.demo.DTOs.SubmittedFormDTO;
import com.example.demo.jpaEnities.FormSubmission;
import com.example.demo.services.SubmittedFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/submittedForms")
public class SubmittedFormController {

    @Autowired
    private SubmittedFormService submittedFormService;

    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    public FormSubmission submitForm(@RequestBody SubmittedFormDTO form){
        return submittedFormService.submitForm(form);
    }

    @RequestMapping(value = "/getSubmittedForms", method = RequestMethod.GET)
    public List<FormSubmission> getSubmittedForms(){
        return submittedFormService.getSubmittedForms();
    }

    @RequestMapping(value = "/deleteSubmittedFormById/{id}", method = RequestMethod.DELETE)
    public void deleteSubmittedFormById(@PathVariable("id") int id){
        submittedFormService.deleteSubmittedFormById(id);
    }

}

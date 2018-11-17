package com.example.demo.services;

import java.util.List;
import com.example.demo.daos.FormDAO;
import com.example.demo.jpaEnities.Borrower;
import com.example.demo.jpaEnities.Form;
import com.example.demo.jpaEnities.Prospect;
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

	public Form getFormDataById(Integer formId){
		return formDao.getFormById(formId);
	}

    public List<Borrower> getAllBorrowers() {
		return formDao.getAllBorrowers();
    }

	public Borrower getBorrowersById(Long borrowerId) {
		return formDao.getBorrowersById(borrowerId);
	}

	public List<Prospect> getAllProspects() {
		return formDao.getAllProspects();
	}

	public Prospect getProspectByCreatingUserId(Long userId) {
		return formDao.getProspectByCreatingUserId(userId);
	}
}

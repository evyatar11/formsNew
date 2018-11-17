package com.example.demo.daos;

import java.util.List;

import com.example.demo.jpaEnities.Borrower;
import com.example.demo.jpaEnities.Form;
import com.example.demo.jpaEnities.Prospect;
import com.example.demo.repository.BorrowerRepository;
import com.example.demo.repository.FormRepository;
import com.example.demo.repository.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mySql")
public class FormDAO {

	@Autowired
	private FormRepository formRepository;

	@Autowired
	private BorrowerRepository borrowerRepository;

	@Autowired
	private ProspectRepository prospectRepository;

	public List<Form> getForms() {
		return formRepository.findAll();
	}

	public Form getFormById(Integer formId){
		return formRepository.findFormByFormId(formId);
	}

    public List<Borrower> getAllBorrowers() {
		return borrowerRepository.findAll();
    }

	public Borrower getBorrowersById(Long borrowerId) {
		return borrowerRepository.findById(borrowerId);
	}

	public List<Prospect> getAllProspects() {
		return prospectRepository.findAll();
	}

	public Prospect getProspectByCreatingUserId(Long userId) {
		return prospectRepository.findByUserId(userId);
	}
}

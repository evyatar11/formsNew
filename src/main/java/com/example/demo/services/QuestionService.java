package com.example.demo.services;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.daos.QuestionDAO;
//import com.example.demo.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	@Autowired
	@Qualifier("mySql")
	private QuestionDAO questionDao;

//	public List<Question> getAllQuestionsForCategory(int categoryId) {
//		try {
//			return questionDao.getAllQuestionsForCategory(categoryId);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}

package com.example.demo.services;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.daos.AnswerDAO;
//import com.example.demo.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

	@Autowired
	@Qualifier("mySql")
	private AnswerDAO answerDao;

//	public List<Answer> getAllAnswersForQuestion() {
//		return getAllAnswersForQuestion();
//	}
//
//	public List<Answer> getAllAnswersForQuestion(int questionId) {
//		try {
//			return answerDao.getAllAnswersForQuestion(questionId);
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

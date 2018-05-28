package com.example.demo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.connectors.MySqlConnector;
//import com.example.demo.entities.Answer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mySql")
public class AnswerDAO {

	
//	public List<Answer> getAllAnswersForQuestion(int questionId) throws SQLException,ClassNotFoundException {
//		ResultSet result = null;
//		PreparedStatement statement = null;
//		List<Answer> answerList = new ArrayList<Answer>();
//		try {
//			Connection conn = MySqlConnector.getConnection();
//			String query = "select * from Answers where questionId = ? ";
//			statement = conn.prepareStatement(query);
//			statement.setInt(1, questionId);
//			result = statement.executeQuery();
//			while(result.next()){
//				answerList.add(new Answer(result.getInt("answerId"),result.getInt("questionId"),result.getString("answerContent"),result.getInt("answerScore")));
//			}
//			return answerList;
//		}
//		finally {
//			if(result != null) result.close();
//			if(statement != null) statement.close();
//		}
//	}
}

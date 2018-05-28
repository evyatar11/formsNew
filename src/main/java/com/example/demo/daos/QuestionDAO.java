package com.example.demo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.connectors.MySqlConnector;
//import com.example.demo.entities.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mySql")
public class QuestionDAO {

//	public List<Question> getAllQuestionsForCategory(int categoryId) throws ClassNotFoundException, SQLException {
//		ResultSet result = null;
//		PreparedStatement statement = null;
//		List<Question> questionsList = new ArrayList<Question>();
//		try {
//			Connection conn = MySqlConnector.getConnection();
//			String query = "select * from Questions where categoryId = ?";
//			statement = conn.prepareStatement(query);
//			statement.setInt(1,categoryId);
//			result =  statement.executeQuery();
//			while(result.next()){
//				Question question = new Question(result.getInt("questionId"),result.getString("questionContent"),result.getDouble("questionWeight"),result.getInt("categoryId"));
//				questionsList.add(question);
//			}
//			return questionsList;
//		} finally {
//			if(result != null) result.close();
//			if(statement != null) statement.close();
//		}
//
//	}
}

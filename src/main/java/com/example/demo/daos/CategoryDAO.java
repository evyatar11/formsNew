package com.example.demo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.connectors.MySqlConnector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("mySql")
public class CategoryDAO {

//	public List<Category> getAllCategories(int formId) throws SQLException,ClassNotFoundException {
//		ResultSet result = null;
//		PreparedStatement statement = null;
//		List<Category> categoriesList = new ArrayList<Category>();
//		try {
//			Connection conn = MySqlConnector.getConnection();
//			String query = "select * from Categories where formid = ?";
//			statement = conn.prepareStatement(query);
//			statement.setInt(1, formId);
//			result = statement.executeQuery();
//			while(result.next()){
//				categoriesList.add(new Category(result.getInt("categoryId"),result.getInt("categoryWeight"),result.getString("categoryName"),result.getInt("formId")));
//			}
//			return categoriesList;
//		}
//		finally {
//			if(result != null) result.close();
//			if(statement != null) statement.close();
//		}
//	}

}

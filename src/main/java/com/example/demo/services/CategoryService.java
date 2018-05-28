package com.example.demo.services;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.daos.CategoryDAO;
//import com.example.demo.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	@Qualifier("mySql")
	private CategoryDAO categoryDao;
	
//	public List<Category> getAllCategories(int formId){
//		try {
//			return categoryDao.getAllCategories(formId);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}

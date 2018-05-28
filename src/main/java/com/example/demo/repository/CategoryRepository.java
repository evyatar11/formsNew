package com.example.demo.repository;

import com.example.demo.jpaEnities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Collection<Category> findCategoryByCategoryId(Integer id);
    Collection<Category> findCategoryByCategoryName(String name);
    Collection<Category> findCategoryByFormId(Integer id);
}
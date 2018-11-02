package com.example.demo.repository;

import com.example.demo.jpaEnities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}

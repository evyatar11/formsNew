package com.example.demo.repository;

import com.example.demo.jpaEnities.BussinessUnit;
import com.example.demo.jpaEnities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BussinessUnitRepository extends JpaRepository<BussinessUnit, Integer> {
}

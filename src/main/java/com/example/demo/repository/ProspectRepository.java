package com.example.demo.repository;

import com.example.demo.jpaEnities.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProspectRepository extends JpaRepository<Prospect, Integer> {
    Prospect findByUserId(Long creatorUserid);
}

package com.example.demo.repository;

import com.example.demo.jpaEnities.USPBpdConv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PdConvRepository extends JpaRepository<USPBpdConv, Integer> {

    @Query(value = "select * from USPBpdConv where :score >= minScore and :score < maxScore",nativeQuery = true)
    USPBpdConv getUpdatedPdAndRating(@Param("score") double score);

}


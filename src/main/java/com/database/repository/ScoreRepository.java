package com.database.repository;

import com.database.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ScoreRepository extends JpaRepository<Score,Integer> {



    @Query(value = "s.score\n" +
            "FROM score AS s \n,"+
            "WHERE s.sql_date > :date,"+
            "ORDER BY s.score DESC", nativeQuery = true)
    List<Map<Integer, Long>> getScoreBoardWithDate(@Param("date") Date date);

}
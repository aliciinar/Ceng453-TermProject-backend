package com.database.repository;

import com.database.entity.ScoreWeek;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository for users score weeks
 */
public interface ScoreWeekRepository extends JpaRepository<ScoreWeek,Integer> {

}
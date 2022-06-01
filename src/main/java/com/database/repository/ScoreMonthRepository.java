package com.database.repository;

import com.database.entity.ScoreMonth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository for users monthly scores
 */
public interface ScoreMonthRepository extends JpaRepository<ScoreMonth,Integer> {

}
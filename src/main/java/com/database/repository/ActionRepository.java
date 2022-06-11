package com.database.repository;

import com.database.entity.Action;
import com.database.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for user information
 */

public interface ActionRepository extends JpaRepository<Action,Integer> {


}
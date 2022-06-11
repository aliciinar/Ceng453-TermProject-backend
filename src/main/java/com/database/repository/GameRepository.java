package com.database.repository;

import com.database.entity.Game;
import com.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for user information
 */

public interface GameRepository extends JpaRepository<Game,Integer> {

    Game findByUser1(String user1);
    Game findByUser2(String user2);

}
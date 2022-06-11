package com.database.entity;


import com.database.entity.dto.ActionDto;
import com.database.entity.dto.GameDto;
import com.database.entity.dto.ScoreDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ScoreMonth Table
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
@Getter
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // Unique id of the ScoreMonth Entity

    private String user1;

    private String user2;

    private boolean turnUser1 = true;
    private boolean turnUser2 = false;

    private boolean searchUser = true;

    @OneToMany(mappedBy="game")
    private List<Action> actions = new ArrayList<>();

    public Game(String user1) {
        this.user1 = user1;
    }

    public void matchUsers(String user2) {
        this.user2 = user2;
        this.searchUser = false;
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public static Game fromDto(GameDto gameDto) {
        return new Game(gameDto.getName());
    }


}
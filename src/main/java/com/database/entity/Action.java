package com.database.entity;


import com.database.entity.dto.GameDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * ScoreMonth Table
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
@Getter
public class Action {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // Unique id of the ScoreMonth Entity

    private String name;
    private String type;
    private int dice1 , dice2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id", nullable=false)
    @JsonIgnore
    private Game game;


    public Action(String name , String type , int dice1 , int dice2 , Game game) {
        this.name = name;
        this.type = type;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.game = game;
    }

}
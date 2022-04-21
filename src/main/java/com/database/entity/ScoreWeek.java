package com.database.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * ScoreWeek Table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
public class ScoreWeek {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private  User user;

    private int score;
    private java.sql.Date sqlDate;

    public ScoreWeek(int score  ){
        this.sqlDate = new java.sql.Date(System.currentTimeMillis());
        this.score = score;
        this.sqlDate = sqlDate;
    }





}
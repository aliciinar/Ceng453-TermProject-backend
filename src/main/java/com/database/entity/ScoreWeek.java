package com.database.entity;


import com.database.entity.dto.ScoreDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * ScoreWeek Table which contain user - score - score time
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
public class ScoreWeek {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "user", referencedColumnName = "id")
    private  User user;

    private int score;
    private java.sql.Date sqlDate;

    public ScoreWeek(int score ){
        this.sqlDate = new java.sql.Date(System.currentTimeMillis());
        this.score = score;
        this.sqlDate = sqlDate;
    }


    public static ScoreWeek from(ScoreDto dto) {
        ScoreWeek scoreWeek = new ScoreWeek(dto.getScore());
        return scoreWeek;
    }




}
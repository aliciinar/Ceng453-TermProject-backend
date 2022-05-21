package com.database.entity;


import com.database.entity.dto.ScoreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

/**
 * ScoreMonth Table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
public class ScoreMonth {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // Unique id of the ScoreMonth Entity


    @ManyToOne()
    @JoinColumn(name = "user", referencedColumnName = "id")
    private  User user; // Referenced User

    private int score; // Score value
    private java.sql.Date sqlDate; // Score addition date

    /**
     * Initialize Score month entity with the given score and current date.
     * @param score of the game
     */
    public ScoreMonth(int score  ){
        this.sqlDate = new java.sql.Date(System.currentTimeMillis());
        this.score = score;
        this.sqlDate = sqlDate;
    }

    public static ScoreMonth from(ScoreDto dto) {
        ScoreMonth scoreMonth = new ScoreMonth(dto.getScore());
        return scoreMonth;
    }





}
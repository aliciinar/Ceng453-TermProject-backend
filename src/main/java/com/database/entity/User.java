package com.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @OneToMany(mappedBy = "user")
    private Set<Score> scores = new HashSet<>();

    private String name;
    private String email;
    private String password;


    public User(String name , String password , String email){

        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Set<Score> getScores() {
        return scores;
    }



}
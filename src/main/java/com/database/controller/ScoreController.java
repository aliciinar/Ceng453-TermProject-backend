package com.database.controller;

import com.database.entity.Score;
import com.database.entity.User;
import com.database.service.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PostMapping("/user/addScore/{id}")
    @Fetch(value= FetchMode.SELECT)
    public Score addScore(@RequestBody Score Score , @PathVariable String id) {
        return service.saveScore(Score , id);
    }

    @PostMapping("/addScores")
    public List<Score> addScores(@RequestBody List<Score> Scores) {
        return service.saveScores(Scores);
    }

    @GetMapping("/Scores")
    public List<Score> findAllScores() {
        return service.getScores();
    }

    @GetMapping("/ScoreById/{id}")
    public Score findScoreById(@PathVariable int id) {
        return service.getScoreById(id);
    }

    @DeleteMapping("Score/delete/{id}")
    public String deleteScore(@PathVariable int id) {
        return service.deleteScore(id);
    }

    @GetMapping("/ScoresLast7")
    public List<Map<Integer, Long>> getScoresLast7(){ return service.getLastWeekScore(); }

    @GetMapping("/GetAll")
    public List<Score> getAllScores(){ return service.getAllResults(); }

}

package com.database.controller;

import com.database.entity.Score;
import com.database.entity.User;
import com.database.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PostMapping("/addScore")
    public Score addScore(@RequestBody Score Score , User user) {
        return service.saveScore(Score , user);
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
    public List<Score> getScoresLast7(){ return service.getScoresLast7(); }

}

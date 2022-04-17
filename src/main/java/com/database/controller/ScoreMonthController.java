package com.database.controller;

import com.database.entity.ScoreMonth;
import com.database.entity.User;
import com.database.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "MonthlyScores Api documentation")
public class ScoreMonthController {

    @Autowired
    private ScoreMonthService service;

    @ApiOperation(value = "New Score adding method")
    @PostMapping("/addScoreMonth")
    public ScoreMonth addScore(@RequestBody ScoreMonth ScoreMonth, User user) {
        return service.saveScore(ScoreMonth, user);
    }

    @ApiOperation(value = "New Scores adding method")
    @PostMapping("/addScoresMonth")
    public List<ScoreMonth> addScores(@RequestBody List<ScoreMonth> scoreMonths) {
        return service.saveScores(scoreMonths);
    }

    @ApiOperation(value = "Getting all the scores method")
    @GetMapping("/ScoresMonth")
    public List<ScoreMonth> findAllScores() {
        return service.getScores();
    }

    @ApiOperation(value = "Getting score by id method")
    @GetMapping("/ScoreMonthById/{id}")
    public ScoreMonth findScoreById(@PathVariable int id) {
        return service.getScoreById(id);
    }

    @ApiOperation(value = "Updating monthly score table so that it is only contains scores of the last 7*4 day")
    @DeleteMapping("ScoreMonth/update/")
    public String updateScores() {
        return service.updateScores();
    }



}

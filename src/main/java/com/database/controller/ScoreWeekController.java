package com.database.controller;

import com.database.entity.ScoreWeek;
import com.database.entity.User;
import com.database.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "WeeklyScores Api documentation")
public class ScoreWeekController {

    @Autowired
    private ScoreWeekService service;

    @ApiOperation(value = "New Score adding method")
    @PostMapping("/addScoreWeek")
    public ScoreWeek addScore(@RequestBody ScoreWeek ScoreWeek, User user) {
        return service.saveScore(ScoreWeek, user);
    }

    @ApiOperation(value = "New Scores adding method")
    @PostMapping("/addScoresWeek")
    public List<ScoreWeek> addScores(@RequestBody List<ScoreWeek> scoreWeeks) {
        return service.saveScores(scoreWeeks);
    }

    @ApiOperation(value = "Getting all the scores method")
    @GetMapping("/ScoresWeek")
    public List<ScoreWeek> findAllScores() {
        return service.getScores();
    }

    @ApiOperation(value = "Getting score by id method")
    @GetMapping("/ScoreWeekById/{id}")
    public ScoreWeek findScoreById(@PathVariable int id) {
        return service.getScoreById(id);
    }

    @ApiOperation(value = "Updating weekly score table so that it is only contains scores of the last 7 day")
    @DeleteMapping("ScoreWeek/Update/")
    public String updateScores() {
        return service.updateScores();
    }


}

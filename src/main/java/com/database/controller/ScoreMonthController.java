package com.database.controller;

import com.database.entity.ScoreMonth;
import com.database.entity.User;
import com.database.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for ScoreMonth table
 */
@RestController
@Api(value = "ScoreMonth table controller documentation")
public class ScoreMonthController {

    @Autowired
    private ScoreMonthService service; // Service Class for ScoreMonth table

    /**
     * Add row to the ScoreMonth table. User id refers to User entity
     * @param ScoreMonth ScoreMonth entity which is going to be added to the database
     * @param user User entity who has the score
     * @return
     */
    @ApiOperation(value = "New Score adding method")
    @PostMapping("/addScoreMonth")
    public ScoreMonth addScore(@RequestBody ScoreMonth ScoreMonth, @RequestBody User user) {
        return service.saveScore(ScoreMonth, user);
    }


    /**
     *
     * @return All the scores from ScoreMonth table.
     */
    @ApiOperation(value = "Getting all the scores method")
    @GetMapping("/ScoresMonth")
    public List<ScoreMonth> findAllScores() {

        return service.getScores();
    }

    /**
     *
     * @param id id of the wanted user
     * @return User with the given id
     */
    @ApiOperation(value = "Getting score by id method")
    @GetMapping("/ScoreMonthById/{id}")
    public ScoreMonth findScoreById(@PathVariable int id) {
        return service.getScoreById(id);
    }

    /**
     * It updates the ScoreMonth table so that it only holds the entities of the last 28 day
     * @return
     */
    @ApiOperation(value = "Updating monthly score table so that it is only contains scores of the last 7*4 day")
    @DeleteMapping("ScoreMonth/update/")
    public String updateScores() {
        return service.updateScores();
    }





}

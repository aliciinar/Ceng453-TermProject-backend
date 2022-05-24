package com.database.controller;

import com.database.entity.ScoreMonth;
import com.database.entity.dto.ScoreDto;
import com.database.entity.ScoreWeek;
import com.database.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for ScoreWeek table
 */

@RestController
@Api(value = "ScoreWeek table controller documentation")
public class ScoreWeekController {

    @Autowired
    private ScoreWeekService service;

    @Autowired
    private UserService userService;


    @ApiOperation(value = "New Score adding method")
    @PostMapping("/addScoreWeek")
    public ScoreWeek addScore(@RequestBody ScoreDto scoreWeekDto) {
        ScoreWeek scoreWeek = ScoreWeek.from(scoreWeekDto);
        scoreWeek.setUser(userService.getUserByName(scoreWeekDto.getName()));
        System.out.println(userService.getUserByName(scoreWeekDto.getName()));
        return service.saveScore(scoreWeek);
    }

    /**
     *
     * @return All the scores from ScoreWeek table.
     */
    @ApiOperation(value = "Getting all the scores method")
    @GetMapping("/ScoresWeek")
    public List<ScoreWeek> findAllScores() {

        updateScores();
        List<ScoreWeek> scores = service.getScores().stream().sorted(Comparator.comparing(ScoreWeek::getScore)).collect(Collectors.toList());
        return service.getScores();
    }

    /**
     *
     * @param id id of the wanted user
     * @return User with the given id
     */
    @ApiOperation(value = "Getting score by id method")
    @GetMapping("/ScoreWeekById/{id}")
    public ScoreWeek findScoreById(@PathVariable int id) {
        return service.getScoreById(id);
    }

    /**
     * It updates the ScoreWeek table so that it only holds the entities of the last 28 day
     * @return
     */
    @ApiOperation(value = "Updating weekly score table so that it is only contains scores of the last 7 day")
    @DeleteMapping("ScoreWeek/Update/")
    public String updateScores() {
        return service.updateScores();
    }


}

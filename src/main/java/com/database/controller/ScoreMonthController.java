package com.database.controller;

import com.database.entity.ScoreMonth;
import com.database.entity.ScoreWeek;
import com.database.entity.User;
import com.database.entity.dto.ScoreDto;
import com.database.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for ScoreMonth table
 */
@RestController
@Api(value = "ScoreMonth table controller documentation")
public class ScoreMonthController {

    @Autowired
    private ScoreMonthService service; // Service Class for ScoreMonth table

    @Autowired
    private UserService userService;


    @ApiOperation(value = "New Score adding method")
    @PostMapping("/addScoreMonth")
    public ScoreMonth addScore(@RequestBody ScoreDto scoreMonthDto) {
        ScoreMonth scoreMonth = ScoreMonth.from(scoreMonthDto);
        scoreMonth.setUser(userService.getUserByName(scoreMonthDto.getName()));
        return service.saveScore(scoreMonth);
    }

    /**
     *
     * @return All the scores from ScoreMonth table.
     */
    @ApiOperation(value = "Getting all the scores method")
    @GetMapping("/ScoresMonth")
    public List<ScoreMonth> findAllScores() {
        updateScores();
        List<ScoreMonth> scores = service.getScores().stream().sorted(Comparator.comparing(ScoreMonth::getScore)).collect(Collectors.toList());

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

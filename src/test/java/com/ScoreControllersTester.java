package com;

import com.database.controller.ScoreMonthController;
import com.database.controller.ScoreWeekController;
import com.database.controller.UserController;
import com.database.entity.ScoreMonth;
import com.database.entity.ScoreWeek;
import com.database.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

/**
 * This Class tests ScoreWeek and ScoreMonth table
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreControllersTester {

    @Autowired
    private ScoreWeekController scoreWeekController;

    @Autowired
    private ScoreMonthController scoreMonthController;

    @Autowired
    private UserController userController;

    /**
     * Test add new ScoreWeek to the database
     */
    @Test
    public void addNewScoreWeek() {

        int scoreWeekSize = scoreWeekController.findAllScores().size();

        User testUser = userController.findUserByName("UserTest");

        ScoreWeek testScoreWeek = new ScoreWeek(15);

        scoreWeekController.addScore(testScoreWeek , testUser);

        Assert.assertEquals("Week Entity Not added" , scoreWeekSize + 1, scoreWeekController.findAllScores().size() );


    }
    /**
     * Test add new ScoreMonth to the database
     */
    @Test
    public void addNewScoreMonth() {

        int scoreMonthSize = scoreMonthController.findAllScores().size();

        User testUser = userController.findUserByName("UserTest");

        ScoreMonth testScoreMonth = new ScoreMonth(15);

        scoreMonthController.addScore(testScoreMonth , testUser);

        Assert.assertEquals("Month Entity Not added" , scoreMonthSize + 1, scoreMonthController.findAllScores().size() );

    }

    /**
     * Test deletion of the overdue entities from ScoreMonth
     */
    @Test
    public void deleteOverdueEntitiesFromScoreMonthTable() {

        int scoreMonthSize = scoreMonthController.findAllScores().size();

        User testUser = userController.findUserByName("UserTest");

        ScoreMonth testScoreMonth = new ScoreMonth(15);

        testScoreMonth.setSqlDate(new Date(2));

        scoreMonthController.addScore(testScoreMonth , testUser);

        scoreMonthController.updateScores();

        Assert.assertEquals("Month Entity Not deleted" , scoreMonthSize , scoreMonthController.findAllScores().size() );

    }

    /**
     * Test deletion of the overdue entities from ScoreWeek
     */
    @Test
    public void deleteOverdueEntitiesFromScoreWeekTable() {

        int scoreMonthSize = scoreWeekController.findAllScores().size();

        User testUser = userController.findUserByName("UserTest");

        ScoreWeek testScoreWeek = new ScoreWeek(15);

        testScoreWeek.setSqlDate(new Date(123123));

        scoreWeekController.addScore(testScoreWeek , testUser);

        scoreWeekController.updateScores();

        Assert.assertEquals("Week Entity Not deleted" , scoreMonthSize , scoreWeekController.findAllScores().size() );

    }









}

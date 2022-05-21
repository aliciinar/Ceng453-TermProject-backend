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



    }
    /**
     * Test add new ScoreMonth to the database
     */
    @Test
    public void addNewScoreMonth() {



    }

    /**
     * Test deletion of the overdue entities from ScoreMonth
     */
    @Test
    public void deleteOverdueEntitiesFromScoreMonthTable() {


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

        scoreWeekController.updateScores();

        Assert.assertEquals("Week Entity Not deleted" , scoreMonthSize , scoreWeekController.findAllScores().size() );

    }









}

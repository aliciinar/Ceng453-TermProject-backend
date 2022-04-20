package com.database.service;

import com.database.entity.ScoreMonth;
import com.database.entity.ScoreWeek;
import com.database.entity.User;
import com.database.repository.ScoreMonthRepository;
import com.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service

public class ScoreMonthService {

    @Autowired
    private ScoreMonthRepository scoreMonthRepository;

    @Autowired
    private UserRepository userRepository;

    public ScoreMonth saveScore(ScoreMonth scoreMonth, User user) {

        try {
            validateUserAndScore(scoreMonth , user);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

        assignUserToScore(scoreMonth, user);
        System.out.println("Score Added Successfully");
        return scoreMonthRepository.save(scoreMonth);
    }

    private void validateUserAndScore(ScoreMonth score , User user){

        Assert.notNull(user , "User is null.");
        Assert.notNull(score , "Score is null.");

    }


    public List<ScoreMonth> getScores() {
        return scoreMonthRepository.findAll();
    }

    public ScoreMonth getScoreById(int id) {
        return scoreMonthRepository.findById(id).orElse(null);
    }

    public void assignUserToScore(ScoreMonth scoreMonth, User user) {

        scoreMonth.setUser(user);

    }


    public String updateScores() {
        List<ScoreMonth> scoreMonths = scoreMonthRepository.findAll();
        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

        for(ScoreMonth scoreMonth : scoreMonths){
            if ((today.getTime() - scoreMonth.getSqlDate().getTime()) / 100 > (6048000 * 4)  ){
                scoreMonthRepository.delete(scoreMonth);
            }
        }
        return "Month table Updated";
    }

}


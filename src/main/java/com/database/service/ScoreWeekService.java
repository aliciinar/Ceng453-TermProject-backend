package com.database.service;

import com.database.entity.ScoreMonth;
import com.database.entity.ScoreWeek;
import com.database.entity.User;
import com.database.repository.ScoreWeekRepository;
import com.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ScoreWeekService {

    @Autowired
    private ScoreWeekRepository scoreWeekRepository;

    @Autowired
    private UserRepository userRepository;

    public ScoreWeek saveScore(ScoreWeek scoreWeek, User user) {
        assignUserToScore(scoreWeek, user);
        return scoreWeekRepository.save(scoreWeek);
    }

    public List<ScoreWeek> saveScores(List<ScoreWeek> scoreWeeks) {
        return scoreWeekRepository.saveAll(scoreWeeks);
    }

    public List<ScoreWeek> getScores() {
        return scoreWeekRepository.findAll();
    }

    public ScoreWeek getScoreById(int id) {
        return scoreWeekRepository.findById(id).orElse(null);
    }

    public void assignUserToScore(ScoreWeek scoreWeek, User user) {

        scoreWeek.setUser(user);

    }




    public String updateScores() {
        List<ScoreWeek> scoreWeeks = scoreWeekRepository.findAll();
        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

        for(ScoreWeek scoreWeek : scoreWeeks){
            if ((today.getTime() - scoreWeek.getSqlDate().getTime())/100 > (6048000)  ){
                scoreWeekRepository.deleteById(scoreWeek.getId());
            }
        }
        return "Week Table Updated";
    }

}


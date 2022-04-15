package com.database.service;

import com.database.entity.Score;
import com.database.entity.User;
import com.database.repository.ScoreRepository;
import com.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service

public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    public Score saveScore(Score score , User user) {
        assignUserToScore(score , user);
        return scoreRepository.save(score);
    }

    public List<Score> saveScores(List<Score> Scores) {
        return scoreRepository.saveAll(Scores);
    }

    public List<Score> getScores() {
        return scoreRepository.findAll();
    }

    public Score getScoreById(int id) {
        return scoreRepository.findById(id).orElse(null);
    }

    public void assignUserToScore(Score score , User user) {

        score.setUser(user);

    }

    public List<Score> getScoresLast7(){

        List<Score> scores = getScores();
        List<Score> last7Scores = getScores() ;
        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
        for(Score score : scores){
            if (today.getTime() - score.getSqlDate().getTime() > 604800000  ){
                last7Scores.remove(score);
            }
        }
        return last7Scores;

    }

    public String deleteScore(int id) {
        scoreRepository.deleteById(id);
        return "Score removed !! " + id;
    }

}


package com.database;


import com.database.controller.ScoreController;
import com.database.controller.UserController;
import com.database.entity.Score;
import com.database.entity.User;



import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.stereotype.*;

import java.sql.Date;

@EnableEncryptableProperties
@Controller
@SpringBootApplication
public class SpringBootAppApplication {

    @Autowired
    UserController user;
    @Autowired
    ScoreController score;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "asd";
    }

    @RequestMapping("/register")
    @ResponseBody
    String register() {


        System.out.println(score.getScoresLast7().size());

        return "success";
    }





    public User loginUser(String name , String password){

        User requestedUser = user.findUserByName(name);
        if (requestedUser == null){
            return null;
        }
        else if(requestedUser.getPassword() != password){
            return null;
        }
        else{
            return requestedUser;
        }

    }



    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppApplication.class, args);
    }
}
package com;


import com.database.controller.ScoreMonthController;
import com.database.controller.ScoreWeekController;
import com.database.controller.UserController;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.stereotype.*;


@EnableEncryptableProperties
@Controller
@SpringBootApplication

public class SpringBootAppApplication {


    @Autowired
    UserController uc;

    @Autowired
    ScoreWeekController sc;

    @Autowired
    ScoreMonthController sm;

    @RequestMapping("/")
    @ResponseBody
    String home() {



        sc.updateScores();
        sm.updateScores();


        return "asd";
    }






    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppApplication.class, args);
    }
}
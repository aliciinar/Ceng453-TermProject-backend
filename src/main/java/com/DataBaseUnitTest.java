package com;


import com.database.controller.ForgotPasswordController;
import com.database.controller.ScoreMonthController;
import com.database.controller.ScoreWeekController;
import com.database.controller.UserController;

import com.database.entity.ScoreWeek;
import com.database.entity.User;
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

public class DataBaseUnitTest {


    @Autowired
    UserController uc;

    @Autowired
    ScoreWeekController sc;

    @Autowired
    ScoreMonthController sm;

    @Autowired
    ForgotPasswordController pc;

    @RequestMapping("/")
    @ResponseBody
    void home() {

    }



    public static void main(String[] args) {
        SpringApplication.run(DataBaseUnitTest.class, args);
    }
}
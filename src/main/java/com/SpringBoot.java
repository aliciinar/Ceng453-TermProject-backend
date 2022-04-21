package com;


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

public class SpringBoot {

    @Autowired
    private UserController userService;

    @Autowired
    private ScoreWeekController sw;

    @RequestMapping("/")
    @ResponseBody
    void home() {

        User testUser = userService.findUserByName("UserTest");
        userService.updateUser("UserTest","UserTest");
        sw.addScore(new ScoreWeek(12) , testUser);

    }



    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }
}
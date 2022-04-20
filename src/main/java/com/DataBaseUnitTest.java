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
        testUserTable();
    }

    private void Tests(){


    }

    private void testUserTable(){
        System.out.println(">>>>>Task TestUserTable Started ");

        System.out.println("Adding Test User named UserTest with password UserTest and email saitsutss@gmail.com");
        uc.register(new User("UserTest","UserTest","saitsutss@gmail.com"));
        System.out.println("--------------");
        System.out.println("Adding Test User named UserTest2 with password UserTest2 and email saitsutss@gmail.com");
        uc.register(new User("UserTest2","UserTest2","saitsutss@gmail.com"));
        System.out.println("--------------");
        System.out.println("Adding Test User named UserTest with password UserTest2 and email saitsutss@gmail.com");
        uc.register(new User("UserTest","UserTest2","saitsutss@gmail.com"));
        System.out.println("--------------");
        System.out.println("Deleting user UserTest");
        uc.deleteUser(uc.findUserByName("UserTest").getId());
        System.out.println("--------------");
        System.out.println("Finding user UserTest2");
        if(uc.findUserByName("UserTest2") != null){
            System.out.println("User Found");
        }
        else{
            System.out.println("User Not Found");
        }

        User user = uc.findUserByName("UserTest2");
        System.out.println(user.getPassword());
        pc.processResetPassword("UserTest2" , "12345");
        System.out.println(user.getPassword());
        System.out.println("<<<<<Task TestUserTable Finished ");

    }


    private void testWeekTable(){

        System.out.println(">>>>>Task TestWeekTable Started ");
        System.out.println("Adding a new ScoreWeek entity with score 10 and referencing User UserTest2");
        sc.addScore(new ScoreWeek(10) , uc.findUserByName("UserTest2"));

    }

    public static void main(String[] args) {
        SpringApplication.run(DataBaseUnitTest.class, args);
    }
}
package com.database;


import com.database.controller.UserController;
import com.database.entity.User;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class SpringBootAppApplication {

    @Autowired UserController user;

    @RequestMapping("/")
    @ResponseBody
    String home() {

        user.addUser(new User("as","bs"));
        return "Hello Test commit2";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppApplication.class, args);
    }
}
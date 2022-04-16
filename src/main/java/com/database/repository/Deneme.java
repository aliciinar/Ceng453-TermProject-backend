package com.database.repository;

import com.database.controller.UserController;
import com.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
@RestController

public class Deneme {

    @Autowired
    UserController user;

    /*@RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody*/
    public String getReminder(){
        return "my reminder";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    String register() {
        System.out.println("Login denmesi");
        return registerUser("sait","yes","xd");
    }

    public String registerUser(String name , String password , String email){
        System.out.println("Deneme");
        if (user.findUserByName(name) == null){
            System.out.println("null");
            user.addUser(new User(name , password , email));
            return "User" + name + "Added";
        }
        else{
            System.out.println("null değil");

            return "User" + name + "Exists";
        }


    }
}

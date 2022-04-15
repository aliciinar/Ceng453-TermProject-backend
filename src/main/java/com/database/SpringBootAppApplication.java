package com.database;


import com.database.controller.UserController;
import com.database.entity.User;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.stereotype.*;
import org.springframework.web.servlet.view.RedirectView;

@EnableEncryptableProperties
@Controller
@SpringBootApplication
public class SpringBootAppApplication {

    @Autowired
    UserController user;

    @RequestMapping("/")
    @ResponseBody
    String home() {


        return "asd";
    }

    @RequestMapping("/register")
    @ResponseBody
    String register() {
        return registerUser("sait","yes","xd");
    }


    public String registerUser(String name , String password , String email){

        if (user.findUserByName(name) == null){
            user.addUser(new User(name , password , email));
            return "User" + name + "Added";
        }
        else{
            return "User" + name + "Exists";
        }


    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppApplication.class, args);
    }
}
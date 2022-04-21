package com;


import com.database.entity.User;
import com.database.service.UserService;
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



    @RequestMapping("/")
    @ResponseBody
    void home() {

    }



    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }
}
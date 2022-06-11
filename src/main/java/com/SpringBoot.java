package com;


import com.database.controller.ScoreWeekController;
import com.database.controller.UserController;
import com.database.entity.ScoreWeek;
import com.database.entity.User;
import com.database.repository.GameRepository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.Model;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableEncryptableProperties
@Controller
@SpringBootApplication
@EnableSwagger2

public class SpringBoot {

    @Autowired
    private UserController userService;

    @Autowired
    private ScoreWeekController sw;




    public static void main(String[] args) {

        SpringApplication.run(SpringBoot.class, args);
    }
}
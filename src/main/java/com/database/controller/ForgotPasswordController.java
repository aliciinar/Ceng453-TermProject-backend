package com.database.controller;

import com.database.entity.User;
import com.database.entity.dto.ForgetPasswordDto;
import com.database.security.TokenManager;
import com.database.service.UserService;
import com.mail.Mail;
import com.mail.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * Controller for password reset
 */
@RestController
@Api(value = "Password Reset Controller Documentation")
public class ForgotPasswordController {
    @Autowired
    private MailService ms; // Mail service for mail sending

    @Autowired
    private UserService us; // User Table service for getting user emails.

    @Autowired
    private TokenManager tokenManager;

    private Map<String , String> tokens = new HashMap<>();


    @ApiOperation(value = "Sends mail to the user with given email and name. User must have the same email value with the parameter email")
    @PostMapping("/forgot_password")
    public String processForgotPassword(@RequestBody ForgetPasswordDto name) throws Exception {

        User user = us.getUserByEMail(name.getName());
        if(user == null) return "Email is not registered";
        sentMail(user);
        return "Email has been sent";

    }
    @ApiOperation(value = "Confirms Password Reset Action")
    @RequestMapping(value="/confirm-reset", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        if(tokens.keySet().contains(confirmationToken)){
            String name = tokens.get(confirmationToken);
            User tmpUser = new User();
            tmpUser.setName(name);
            modelAndView.addObject("user" , tmpUser);
            tokens.remove(confirmationToken);
            modelAndView.setViewName("resetPassword");

        }

        else{
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }


    private void sentMail(User user){
        Mail mail = new Mail();
        String token = tokenManager.generateToken(user.getName());
        tokens.put(token , user.getName());
        mail.setMailFrom("453group4@gmail.com");
        mail.setMailTo(user.getEmail());
        mail.setMailSubject("Spring Boot - Reset Password");
        mail.setMailContent("To complete the password reset process, please click here: "
                + "https://ceng453-term-project-group-4.herokuapp.com/confirm-reset?token="+token);
        ms.sendEmail(mail);
    }

    @ApiOperation(value = "Reset the Password")
    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public ModelAndView resetUserPassword(ModelAndView modelAndView, User user) {
        try {
            us.updateUser(user.getName() , user.getPassword());
            if(user == null) System.out.println("Null User");
            modelAndView.addObject("message","Password has been changed");
            modelAndView.setViewName("error");

            return modelAndView;
        }
        catch (IllegalArgumentException e){

            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
            return modelAndView;

        }
    }
}

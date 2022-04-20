package com.database.controller;

import com.database.entity.User;
import com.database.service.UserService;
import com.mail.Mail;
import com.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgotPasswordController {
    @Autowired
    private MailService ms;

    @Autowired
    private UserService us;



    @PostMapping("/forgot_password")
    public void processForgotPassword(@RequestBody String name , @RequestBody String email) {
        User user = us.getUserByName(name);
        Assert.notNull(user , "User Not Exists");
        System.out.println(email + " - " + user.getEmail());
        Assert.isTrue(user.getEmail().equals(email) , "Email is Wrong");
        sentMail(email);

    }

    private void sentMail(String email){
        Mail mail = new Mail();
        mail.setMailFrom("453group4@gmail.com");
        mail.setMailTo(email);
        mail.setMailSubject("Spring Boot - Reset Password");
        mail.setMailContent("Click here to Reset your password ( Will be implemented in frontend) ");
        ms.sendEmail(mail);
    }


    @PostMapping("/reset_password")
    public void processResetPassword(@RequestBody String name , @RequestBody String password) {
        us.updateUser(name , password);
    }
}

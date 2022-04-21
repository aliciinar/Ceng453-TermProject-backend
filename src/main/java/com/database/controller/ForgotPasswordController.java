package com.database.controller;

import com.database.entity.User;
import com.database.service.UserService;
import com.mail.Mail;
import com.mail.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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


    /**
     * Send password reset mail to the user with given name.
     * If user do not exist or user email is not equal to requested email it throws exception.
     * @param name of the user
     * @param email email of the user
     */
    @ApiOperation(value = "Sends mail to the user with given email and name. User must have the same email value with the parameter email")
    @PostMapping("/forgot_password")
    public void processForgotPassword(@RequestBody String name , @RequestBody String email) throws Exception {
        User user = us.getUserByName(name);
        Assert.notNull(user , "User Not Exists");
        Assert.isTrue(user.getEmail().equals(email) , "Email is Wrong");
        sentMail(email);

    }

    /**
     * Helper method for the processForgotPassword
     * It prepares the mail information and send them when ready.
     * @param email email of to receiver end
     */
    private void sentMail(String email){
        Mail mail = new Mail();
        mail.setMailFrom("453group4@gmail.com");
        mail.setMailTo(email);
        mail.setMailSubject("Spring Boot - Reset Password");
        mail.setMailContent("Click here to Reset your password ( Will be implemented in frontend) ");
        ms.sendEmail(mail);
    }


    /**
     * Changes user password to the new password
     * This method is called after user receive forgot password mail
     * @param name name of the user which will have password reset
     * @param password new password
     */
    @PostMapping("/reset_password")
    @ApiOperation(value = "Reset password to the given password if user with the given name exists")
    public void processResetPassword(@RequestBody String name , @RequestBody String password) {
        us.updateUser(name , password);
    }
}

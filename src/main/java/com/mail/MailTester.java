package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication

public class MailTester {
    public static void main(String[] args) {

        Mail mail = new Mail();
        mail.setMailFrom("453group4@gmail.com");
        mail.setMailTo("453group4@gmail.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("This is a email Tester from myself <3");

        ApplicationContext ctx = SpringApplication.run(MailTester.class, args);
        MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);

    }
}

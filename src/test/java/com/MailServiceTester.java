package com;

import com.mail.Mail;
import com.mail.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for mail verification.
 */
@SpringBootTest
public class MailServiceTester {

    @Autowired
    private MailService ms;

    @Test
    public void testSendEmailToUs() {

        Mail mail = new Mail();
        mail.setMailFrom("453group4@gmail.com");
        mail.setMailTo("453group4@gmail.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("This is a email Tester from myself <3");
        ms.sendEmail(mail);

    }
}

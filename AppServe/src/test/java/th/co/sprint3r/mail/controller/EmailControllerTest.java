package th.co.sprint3r.mail.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import th.co.sprint3r.mail.model.Email;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;

import static org.junit.Assert.*;

public class EmailControllerTest {

    private Email email = new Email("sprint3rmail", "sprint3rsmtp@gmail.com", "", "Subject", "Body");

    @Test
    public void sendEmail() throws Exception {
        EmailController emailController = new EmailController();
        JavaMailSenderMock sender = new JavaMailSenderMock();
        emailController.sender = sender;

        emailController.sendEmail(email);
        sender.assertShouldCallSend(1);
    }

    private class JavaMailSenderMock extends JavaMailSenderImpl {
        int count;

        @Override
        public void send(MimeMessage mimeMessage) throws MailException {
            count++;
        }

        public void assertShouldCallSend(int time){
            assertEquals(time, count);
        }

    }

}
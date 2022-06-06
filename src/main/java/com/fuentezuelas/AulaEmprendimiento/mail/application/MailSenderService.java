package com.fuentezuelas.AulaEmprendimiento.mail.application;

import com.fuentezuelas.AulaEmprendimiento.mail.infrastructure.repository.MailRepository;
import com.sun.mail.smtp.SMTPSaslAuthenticator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to, String subject, String body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        message.setSubject(subject);

        helper = new MimeMessageHelper(message,true);
        helper.setText(body,true);
        helper.setTo(to);
        helper.setFrom("virtual.travel.exercise@gmail.com");


        mailSender.send(message);
    }
}

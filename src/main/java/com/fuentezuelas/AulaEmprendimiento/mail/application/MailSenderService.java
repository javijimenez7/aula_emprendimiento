package com.fuentezuelas.AulaEmprendimiento.mail.application;

import com.fuentezuelas.AulaEmprendimiento.mail.infrastructure.repository.MailRepository;
import com.sun.mail.smtp.SMTPSaslAuthenticator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to, String subject, String body){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(body);
        message.setTo(to);
        message.setFrom("virtual.travel.exercise@gmail.com");
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mensaje enviado a " + to);
    }
}

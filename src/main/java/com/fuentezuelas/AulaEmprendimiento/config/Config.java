package com.fuentezuelas.AulaEmprendimiento.config;

import com.fuentezuelas.AulaEmprendimiento.ficheros.StorageProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Config {
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("ejemplocorreoaula@gmail.com");
        mailSender.setPassword("nvysufiankorjpac");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    public StorageProperties StorageProperties() {

        StorageProperties storageProperties = new StorageProperties();


        /**
         * Folder location for storing files
         */
        storageProperties.setLocation("src\\main\\resources\\static\\misArchivos\\img");

        return storageProperties;

    }


}

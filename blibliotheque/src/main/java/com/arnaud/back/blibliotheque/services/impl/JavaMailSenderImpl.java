package com.arnaud.back.blibliotheque.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class JavaMailSenderImpl {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,String subject,String body)
    {

        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom("derisbourgarnaud@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Email envoyer avec succes!");
    }
}

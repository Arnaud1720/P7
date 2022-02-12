package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.EmailSerderAPI;
import com.arnaud.back.blibliotheque.services.impl.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderContrler implements EmailSerderAPI {

    @Autowired
    private EmailSenderServiceImpl emailSenderService;


    @Override
    public void sendEmailMessage(String toEmail, String body, String subject) {
        emailSenderService.sendEmailMessage(toEmail,body,subject);
    }
}

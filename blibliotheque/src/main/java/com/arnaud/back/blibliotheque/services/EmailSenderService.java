package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Account;

public interface EmailSenderService {
    void sendEmailMessage(String toEmail, String body, String subject);
}

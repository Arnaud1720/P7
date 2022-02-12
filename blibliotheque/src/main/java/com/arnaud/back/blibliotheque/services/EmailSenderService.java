package com.arnaud.back.blibliotheque.services;

public interface EmailSenderService {
    void sendEmailMessage(String toEmail, String body, String subject);
}

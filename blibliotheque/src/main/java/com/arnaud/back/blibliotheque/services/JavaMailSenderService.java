package com.arnaud.back.blibliotheque.services;

public interface JavaMailSenderService {
    void sendEmail(String toEmail, String subject, String body);
}

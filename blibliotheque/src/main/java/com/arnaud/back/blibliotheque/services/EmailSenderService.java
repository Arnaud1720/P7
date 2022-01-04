package com.arnaud.back.blibliotheque.services;

public interface EmailSenderService {
    public void sendEmailMessage(String toEmail,String body,String subject);
}

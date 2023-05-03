package com.ofud.ofud.email;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}

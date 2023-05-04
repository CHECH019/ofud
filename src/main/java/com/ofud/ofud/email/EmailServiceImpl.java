package com.ofud.ofud.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{
    private final JavaMailSender emailSender;
    public void sendSimpleMessage(
        String to, String subject, String text) {
          SimpleMailMessage message = new SimpleMailMessage(); 
          message.setFrom("OFUD");
          message.setTo(to); 
          message.setSubject(subject); 
          message.setText(text);
          emailSender.send(message);
      }
    
}

package com.codeup.springblogapp.services;

import com.codeup.springblogapp.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("adMailService")
public class AdEmailService {

//    @Autowired
    public JavaMailSender adEmailSender;

    @Value("${spring.mail.from}") // Can be whatever info you want from application.properties file (e.g. Spring.mail.port)
    private String from;

    public AdEmailService(JavaMailSender adEmailSender) {
        this.adEmailSender = adEmailSender;
    }

    public void prepareAndSend(Ad ad, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(ad.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.adEmailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}

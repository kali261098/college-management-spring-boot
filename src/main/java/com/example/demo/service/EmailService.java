package com.example.demo.service;

import com.example.demo.dto.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

}

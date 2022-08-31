package com.example.demo.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class EnvConfig {

    @Value("${twilio.account.sid}")
    private String twilioAccountSid;


    @Value("${twilio.auth.token}")
    private String twilioAuthToken;
}

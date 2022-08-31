package com.example.demo.controller;

import com.example.demo.config.EnvConfig;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@CrossOrigin
@RestController
public class SmsController {

    @Autowired
    EnvConfig envConfig;

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {
        String sid = "ACb6b29e0f9eefefafd9b07ced38ee4276";
        String token = "ac4b40e68791b0bf7b040201b6ac7a9d";

        Twilio.init(System.getenv(envConfig.getTwilioAccountSid()), System.getenv(envConfig.getTwilioAuthToken()));

        Message.creator(new PhoneNumber("+919786161674"),
                new PhoneNumber("+919626978553"), "Hello from Twilio 📞").create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
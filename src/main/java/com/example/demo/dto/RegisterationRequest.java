package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterationRequest {

    private String name;
    private String phone;
    private String email;
    private String dob;
    private String gender;
    private String address;
    private String ug;
    private String ugper;
    private String hsc;
    private String hscper;
    private String sslc;
    private String sslcper;


}

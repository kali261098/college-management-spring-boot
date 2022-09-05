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
public class TeacherResponse {
    private String name;
    private String phone;
    private String email;
    private String degree;
    private String subject;
    private String dob;
    private String gender;
    private String address;
    private String exp;
}

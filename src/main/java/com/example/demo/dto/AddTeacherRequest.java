package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddTeacherRequest {
    private String name;
    private String phone;
    private String email;
    private String dob;
    private String gender;
    private String address;
    private String degree;
    private String exp;
    private String spc;
}

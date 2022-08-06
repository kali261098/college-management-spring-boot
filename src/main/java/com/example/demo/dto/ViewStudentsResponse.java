package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewStudentsResponse {
    private String name;
    private String email;
    private String phone;
    private String ug;
    private String ugper;
    private String hscper;
    private String sslcper;
    private Boolean isapprove;
}

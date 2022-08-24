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
public class ViewStudentMarkDto {
    private String ut1;
    private String ut2;
    private String ut3;
    private String tut;
    private String at1;
    private String at2;
    private String at3;
    private String aut;
    private String internal;
    private String external;
    private String total;
    private String grade;


}

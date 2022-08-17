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
public class UnitTestDetail {
    private String name;
    private String email;
    private Integer test1;
    private Integer test2;
    private Integer test3;
}

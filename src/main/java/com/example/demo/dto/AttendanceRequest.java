package com.example.demo.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttendanceRequest {
    List<AttendanceDaily> attendanceDailyList;
    private String teacherEmail;
    private Date date;

}

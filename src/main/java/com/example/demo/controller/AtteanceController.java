package com.example.demo.controller;

import com.example.demo.database.Attendance;
import com.example.demo.dto.AttendanceDaily;
import com.example.demo.dto.AttendanceRequest;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Attedance")

public class AtteanceController {
    @Autowired
    AttendanceService attedanceService;

@PostMapping("/DailyAttedance")
    public ResponseEntity<?> attedance(@RequestBody AttendanceRequest attendanceRequest){
    System.out.println(attendanceRequest);
    attedanceService.attendance(attendanceRequest);
    return new ResponseEntity<>(HttpStatus.OK);
}
}

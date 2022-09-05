package com.example.demo.controller;

import com.example.demo.database.Attendance;
import com.example.demo.dto.AttendanceDaily;
import com.example.demo.dto.AttendanceRequest;
import com.example.demo.dto.SemesterMarkDetail;
import com.example.demo.dto.StudentAttendance;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    @GetMapping("/viewAttedance")
    public ResponseEntity<List<AttendanceDaily>> viewAttedance(@RequestParam String email,
                                                               @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        System.out.println(email);
        System.out.println(date);
        List<AttendanceDaily> attendanceDailyList = attedanceService.viewAttendance(email,date);
        return new ResponseEntity<>(attendanceDailyList,HttpStatus.OK);

    }

    @GetMapping("/Student")
    public ResponseEntity<StudentAttendance> studentAttendance(@RequestParam String email,
                                                                 @RequestParam String subject) {
        System.out.println(email);
        System.out.println(subject);
        StudentAttendance attendanceDailyList = attedanceService.studentAttendance(email,subject);
        return new ResponseEntity<>(attendanceDailyList,HttpStatus.OK);

    }


}

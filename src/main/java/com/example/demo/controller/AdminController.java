package com.example.demo.controller;

import com.example.demo.dto.AddTeacherRequest;
import com.example.demo.dto.RegisterationRequest;
import com.example.demo.dto.ViewStudentsResponse;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/addTecher")
    public ResponseEntity<?> addTeacher(@RequestBody AddTeacherRequest addTeacherRequest){
        System.out.println(addTeacherRequest);
        adminService.addTeacher(addTeacherRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/viewStudent")
    public ResponseEntity<List<ViewStudentsResponse>> viewStudents(){
       List<ViewStudentsResponse> viewStudentsResponses= adminService.viewStudents();
        return new ResponseEntity<>(viewStudentsResponses,HttpStatus.OK);
    }
    @GetMapping("/approveStudent")
    public ResponseEntity<?> approveStudent(@RequestParam String email){
        adminService.approveStudent(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    }

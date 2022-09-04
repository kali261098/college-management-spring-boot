package com.example.demo.controller;

import com.example.demo.dto.AddSubjectRequest;
import com.example.demo.dto.AddTeacherRequest;
import com.example.demo.dto.RegisterationRequest;
import com.example.demo.dto.TeacherResponse;
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

    @GetMapping("/deleteTeacher")
    public ResponseEntity<?> deleteSubject(@RequestParam String email) {
        System.out.println(email);
        adminService.deleteTeacher(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getTeacher")
    public ResponseEntity<List<TeacherResponse>> getSubject() {
        System.out.println("Get Subject request");
        List<TeacherResponse> teacherResponses = adminService.getTeacher();
        return new ResponseEntity<>(teacherResponses,HttpStatus.OK);

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

    @GetMapping("/viewTeacher")
    public ResponseEntity<List<AddTeacherRequest>> viewTeacher() {
        return new ResponseEntity<>(HttpStatus.OK);
    }



    }

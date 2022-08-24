package com.example.demo.controller;


import com.example.demo.dto.AddSubjectRequest;
import com.example.demo.dto.AssignmentMarkDetail;
import com.example.demo.dto.AssignmentMarkRequest;
import com.example.demo.dto.SemesterMarkDetail;
import com.example.demo.dto.SemesterMarkRequest;
import com.example.demo.dto.UnitTestDetail;
import com.example.demo.dto.UnitTestMarkRequest;
import com.example.demo.dto.ViewStudentMarkDto;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/saveUnitTest")
    public ResponseEntity<?> saveUnitTestMark(@RequestBody UnitTestMarkRequest unitTestMarkRequest){
        System.out.println(unitTestMarkRequest);
        teacherService.saveUnitTestMark(unitTestMarkRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/viewUnitTest")
    public ResponseEntity<List<UnitTestDetail>> viewUnitTestMark(@RequestParam String email) {
        System.out.println(email);
        List<UnitTestDetail> unitTestDetailList = teacherService.viewUnitTest(email);
        return new ResponseEntity<>(unitTestDetailList,HttpStatus.OK);

    }

    @PostMapping("/saveAssignmentMark")
    public ResponseEntity<?> saveAssignmentMark(@RequestBody AssignmentMarkRequest assignmentMarkRequest){
        System.out.println(assignmentMarkRequest);
        teacherService.saveAssignmentMark(assignmentMarkRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/viewAssignmentMark")
    public ResponseEntity<List<AssignmentMarkDetail>> viewAssignmentMark(@RequestParam String email) {
        System.out.println(email);
        List<AssignmentMarkDetail> assignmentMarkDetails = teacherService.viewAssignmentMark(email);
        return new ResponseEntity<>(assignmentMarkDetails,HttpStatus.OK);

    }

    @GetMapping("/viewSemesterMark")
    public ResponseEntity<List<SemesterMarkDetail>> viewSemesterMark(@RequestParam String email) {
        System.out.println(email);
        List<SemesterMarkDetail> semesterMarkDetails = teacherService.viewSemesterMark(email);
        return new ResponseEntity<>(semesterMarkDetails,HttpStatus.OK);

    }

    @PostMapping("/saveSemesterMark")
    public ResponseEntity<?> saveSemesterMark(@RequestBody SemesterMarkRequest semesterMarkRequest){
        System.out.println(semesterMarkRequest);
        teacherService.saveSemesterMark(semesterMarkRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/viewStudentMark")
    public ResponseEntity<ViewStudentMarkDto> viewStudentMark(@RequestParam String email,@RequestParam String subject) {
        System.out.println(email);
        ViewStudentMarkDto viewStudentMark = teacherService.viewStudentMark(email,subject);
        return new ResponseEntity<>(viewStudentMark,HttpStatus.OK);

    }
}

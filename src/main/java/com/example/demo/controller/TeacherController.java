package com.example.demo.controller;


import com.example.demo.dto.AddSubjectRequest;
import com.example.demo.dto.UnitTestDetail;
import com.example.demo.dto.UnitTestMarkRequest;
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
}

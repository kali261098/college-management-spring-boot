package com.example.demo.controller;

import com.example.demo.dto.AddSubjectRequest;
import com.example.demo.dto.UnitTestDetail;
import com.example.demo.dto.UnitTestMarkRequest;
import com.example.demo.service.SubjectService;
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

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;
    @PostMapping("/addSubject")
    public ResponseEntity<?> addSubject(@RequestBody AddSubjectRequest addSubjectRequest){
        System.out.println(addSubjectRequest);
        subjectService.addSubject(addSubjectRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/deleteSubject")
    public ResponseEntity<?> deleteSubject(@RequestParam String subjectCode) {
        System.out.println(subjectCode);
        subjectService.deleteSubject(subjectCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getSubject")
    public ResponseEntity<List<AddSubjectRequest>> getSubject() {
        System.out.println("Get Subject request");
        List<AddSubjectRequest> addSubjectRequestList = subjectService.getSubject();
        return new ResponseEntity<>(addSubjectRequestList,HttpStatus.OK);

    }

    @GetMapping("/getSubjectList")
    public ResponseEntity<List<String>> getSubjectList() {
        System.out.println("Get Subject request");
        List<AddSubjectRequest> addSubjectRequestList = subjectService.getSubject();
        List<String> subjectList = new ArrayList<>();
        addSubjectRequestList.forEach(addSubjectRequest -> subjectList.add(addSubjectRequest.getSubjectName()));
        return new ResponseEntity<>(subjectList,HttpStatus.OK);

    }

}

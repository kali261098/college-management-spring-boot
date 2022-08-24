package com.example.demo.service;

import com.example.demo.dto.AssignmentMarkDetail;
import com.example.demo.dto.AssignmentMarkRequest;
import com.example.demo.dto.SemesterMarkDetail;
import com.example.demo.dto.SemesterMarkRequest;
import com.example.demo.dto.UnitTestDetail;
import com.example.demo.dto.UnitTestMarkRequest;
import com.example.demo.dto.ViewStudentMarkDto;

import java.util.List;

public interface TeacherService {
    void saveUnitTestMark(UnitTestMarkRequest unitTestMarkRequest);

    List<UnitTestDetail> viewUnitTest(String email);

    void saveAssignmentMark(AssignmentMarkRequest assignmentMarkRequest);

    List<AssignmentMarkDetail> viewAssignmentMark(String email);

    List<SemesterMarkDetail> viewSemesterMark(String email);

    void saveSemesterMark(SemesterMarkRequest semesterMarkRequest);

    ViewStudentMarkDto viewStudentMark(String email,String subject);
}

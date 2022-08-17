package com.example.demo.service;

import com.example.demo.dto.UnitTestDetail;
import com.example.demo.dto.UnitTestMarkRequest;

import java.util.List;

public interface TeacherService {
    void saveUnitTestMark(UnitTestMarkRequest unitTestMarkRequest);

    List<UnitTestDetail> viewUnitTest(String email);
}

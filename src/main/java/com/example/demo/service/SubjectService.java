package com.example.demo.service;

import com.example.demo.dto.AddSubjectRequest;

import java.util.List;

public interface SubjectService {
    void addSubject(AddSubjectRequest addSubjectRequest);

    void deleteSubject(String subjectCode);

    List<AddSubjectRequest> getSubject();
}

package com.example.demo.service;

import com.example.demo.dto.AddTeacherRequest;
import com.example.demo.dto.RegisterationRequest;
import com.example.demo.dto.ViewStudentsResponse;

import java.util.List;

public interface AdminService {

    Boolean addTeacher(AddTeacherRequest addTeacherRequest);

    List<ViewStudentsResponse> viewStudents();

    void approveStudent(String email);
}

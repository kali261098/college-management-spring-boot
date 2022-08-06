package com.example.demo.service;

import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterationRequest;

public interface UserService {

    Boolean registerUser(RegisterationRequest registerationRequest);

    LoginResponse loginUser(String email);
}

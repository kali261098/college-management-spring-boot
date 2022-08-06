package com.example.demo.controller;


import com.example.demo.dto.AddTeacherRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterationRequest;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> storeUser(@RequestBody RegisterationRequest s) {
        System.out.println(s);
        userService.registerUser(s);
        return new ResponseEntity<>(HttpStatus.OK);
}
@GetMapping("/login")
public ResponseEntity<LoginResponse> getUSer(@RequestParam String email){
        System.out.println(email);
    LoginResponse res=userService.loginUser(email);
     if(res==null){
         return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
     }

     return new ResponseEntity<>(res,HttpStatus.OK);

}

}

package com.example.demo.service;

import com.example.demo.Repo.AdmissionRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.database.AdmissionDetail;
import com.example.demo.database.User;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    AdmissionRepo admissionRepo;

    @Override
    public Boolean registerUser(RegisterationRequest s) {
        AdmissionDetail admission=new AdmissionDetail();
        admission.setName(s.getName());
        admission.setEmail(s.getEmail());
        admission.setPhone(s.getPhone());
        admission.setGender(s.getGender());
        admission.setDob(s.getDob());
        admission.setAddress(s.getAddress());
        admission.setUg(s.getUg());
        admission.setUgper((s.getUgper()));
        admission.setHsc(s.getHsc());
        admission.setHscper(s.getHscper());
        admission.setSslc(s.getSslc());
        admission.setSslcper(s.getSslcper());
        admission.setIsapprove(false);


        admissionRepo.save(admission);

        return null;
    }

    @Override
    public LoginResponse loginUser(String email) {
        List<User> userList = userRepo.findByEmail(email);
        if(ObjectUtils.isEmpty(userList))
        {
            return null;
        }
        User user=userList.get(0);
        LoginResponse r=new LoginResponse();
        r.setPassword(user.getPassword());
        r.setRole(user.getRole());

        return r;

    }
}

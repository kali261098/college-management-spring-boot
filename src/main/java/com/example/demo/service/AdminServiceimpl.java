package com.example.demo.service;

import com.example.demo.Repo.AdmissionRepo;
import com.example.demo.Repo.TeaacherRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.database.AdmissionDetail;
import com.example.demo.database.TeacherDetail;
import com.example.demo.database.User;
import com.example.demo.dto.AddTeacherRequest;
import com.example.demo.dto.EmailDetails;
import com.example.demo.dto.TeacherResponse;
import com.example.demo.dto.ViewStudentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceimpl implements AdminService{
    @Autowired
    TeaacherRepo teaacherRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    EmailService emailService;
    @Autowired
    AdmissionRepo admissionRepo;



    @Override
    public Boolean addTeacher(AddTeacherRequest addTeacherRequest) {
        TeacherDetail teacher =teaacherRepo.findByEmail(addTeacherRequest.getEmail());
        if(ObjectUtils.isEmpty(teacher)){
            teacher = new TeacherDetail();
        }
        teacher.setName(addTeacherRequest.getName());
        teacher.setDob(addTeacherRequest.getDob());
        teacher.setEmail(addTeacherRequest.getEmail());
        teacher.setAddress(addTeacherRequest.getAddress());
        teacher.setPhone(addTeacherRequest.getPhone());
        teacher.setGender(addTeacherRequest.getGender());
        teacher.setDegree(addTeacherRequest.getDegree());
        teacher.setExp(addTeacherRequest.getExp());
        teacher.setSpc(addTeacherRequest.getSpc());
        teaacherRepo.save(teacher);
       User user= createUserCredentials("teacher",addTeacherRequest.getEmail(),addTeacherRequest.getPhone());
        return null;
    }

    @Override
    public List<ViewStudentsResponse> viewStudents() {
        List<AdmissionDetail> admissionDetailList=admissionRepo.findAll();
        List<ViewStudentsResponse> viewStudentsResponseList=new ArrayList<>();
        for(AdmissionDetail admissionDetail:admissionDetailList){
            ViewStudentsResponse viewStudentsResponse=new ViewStudentsResponse();
            viewStudentsResponse.setName(admissionDetail.getName());
            viewStudentsResponse.setEmail(admissionDetail.getEmail());
            viewStudentsResponse.setPhone(admissionDetail.getPhone());
            viewStudentsResponse.setUg(admissionDetail.getUg());
            viewStudentsResponse.setUgper(admissionDetail.getUgper());
            viewStudentsResponse.setHscper(admissionDetail.getHscper());
            viewStudentsResponse.setSslcper(admissionDetail.getSslcper());
            viewStudentsResponse.setIsapprove(admissionDetail.getIsapprove());
            viewStudentsResponseList.add(viewStudentsResponse);


        }
        return viewStudentsResponseList;
    }

    @Override
    public void approveStudent(String email) {
        AdmissionDetail admissionDetail=admissionRepo.findByEmail(email);
        admissionDetail.setIsapprove(true);
        admissionRepo.save(admissionDetail);
        User user=createUserCredentials("student",email, admissionDetail.getPhone());
//        EmailDetails emailDetails=new EmailDetails();
//        emailDetails.setRecipient(email);
//        emailDetails.setSubject("congratulation your select for thi course");
//        emailDetails.setMsgBody("your password is"+user.getPassword());
//        emailService.sendSimpleMail(emailDetails);

    }

    @Override
    public void deleteTeacher(String email) {
        TeacherDetail teacherDetail = teaacherRepo.findByEmail(email);
        teaacherRepo.delete(teacherDetail);
        List<User> user = userRepo.findByEmail(email);
        userRepo.delete(user.get(0));
    }

    @Override
    public List<TeacherResponse> getTeacher() {
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        List<TeacherDetail> teacherDetailList = teaacherRepo.findAll();
        if(!ObjectUtils.isEmpty(teacherDetailList)){
            teacherDetailList.forEach(teacherDetail -> {
                TeacherResponse teacherResponse = new TeacherResponse();
                teacherResponse.setSubject(teacherDetail.getSpc());
                teacherResponse.setName(teacherDetail.getName());
                teacherResponse.setEmail(teacherDetail.getEmail());
                teacherResponse.setPhone(teacherDetail.getPhone());
                teacherResponse.setDegree(teacherDetail.getDegree());
                teacherResponses.add(teacherResponse);
            });
        }
        return teacherResponses;
    }

    public User createUserCredentials(String role, String email,String phone){
        User user=new User();
        user.setEmail(email);
        user.setRole(role);
        user.setPassword(phone);
        userRepo.save(user);
        return user;
    }
    public String password(){
        int pass=(int) (Math.random()*9000)+1000;
        return String.valueOf(pass);
    }
}

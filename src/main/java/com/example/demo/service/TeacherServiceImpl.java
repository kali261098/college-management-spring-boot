package com.example.demo.service;

import com.example.demo.Repo.AdmissionRepo;
import com.example.demo.Repo.TeaacherRepo;
import com.example.demo.Repo.UnitTestRepo;
import com.example.demo.database.AdmissionDetail;
import com.example.demo.database.TeacherDetail;
import com.example.demo.database.UnitTestMark;
import com.example.demo.dto.UnitTestDetail;
import com.example.demo.dto.UnitTestMarkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeaacherRepo teaacherRepo;
    @Autowired
    UnitTestRepo unitTestRepo;
    @Autowired
    AdmissionRepo admissionRepo;
    @Override
    public void saveUnitTestMark(UnitTestMarkRequest unitTestMarkRequest) {
        TeacherDetail teacherDetail = teaacherRepo.findByEmail(unitTestMarkRequest.getEmail());
        unitTestMarkRequest.getUnitTestList().forEach(unitTestDetail -> {
            UnitTestMark unitTestMark = unitTestRepo.findBySubjectNameAndStudentEmailAndStudentName(
                    teacherDetail.getSpc(),
                    unitTestDetail.getEmail(),
                    unitTestDetail.getName());
            if(ObjectUtils.isEmpty(unitTestMark)) {
                unitTestMark = new UnitTestMark();
                unitTestMark.setSubjectName(teacherDetail.getSpc());
                unitTestMark.setStudentName(unitTestDetail.getName());
                unitTestMark.setStudentEmail(unitTestDetail.getEmail());
            }
            unitTestMark.setUnitTest1(unitTestDetail.getTest1());
            unitTestMark.setUnitTest2(unitTestDetail.getTest2());
            unitTestMark.setUnitTest3(unitTestDetail.getTest3());
            unitTestRepo.save(unitTestMark);
        });


    }

    @Override
    public List<UnitTestDetail> viewUnitTest(String email) {
        TeacherDetail teacherDetail = teaacherRepo.findByEmail(email);
        List<UnitTestMark> unitTestMarkList = unitTestRepo.findBySubjectName(teacherDetail.getSpc());
        List<UnitTestDetail> unitTestDetailList = new ArrayList<>();
        if(!ObjectUtils.isEmpty(unitTestMarkList)) {
            unitTestMarkList.forEach(
                    unitTestMark -> {
                        UnitTestDetail unitTestDetail = new UnitTestDetail();
                        unitTestDetail.setName(unitTestMark.getStudentName());
                        unitTestDetail.setEmail(unitTestMark.getStudentEmail());
                        unitTestDetail.setTest1(unitTestMark.getUnitTest1());
                        unitTestDetail.setTest2(unitTestMark.getUnitTest2());
                        unitTestDetail.setTest3(unitTestMark.getUnitTest3());
                        unitTestDetailList.add(unitTestDetail);
                    });
            return unitTestDetailList;
        } else {
            List<AdmissionDetail> admissionDetailList = admissionRepo.findByIsapprove(true);
            admissionDetailList.forEach(admissionDetail -> {
                UnitTestDetail unitTestDetail = new UnitTestDetail();
                unitTestDetail.setName(admissionDetail.getName());
                unitTestDetail.setEmail(admissionDetail.getEmail());
                unitTestDetail.setTest1(0);
                unitTestDetail.setTest2(0);
                unitTestDetail.setTest3(0);
                unitTestDetailList.add(unitTestDetail);
            });
            return unitTestDetailList;
        }
    }
}

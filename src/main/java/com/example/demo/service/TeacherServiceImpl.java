package com.example.demo.service;

import com.example.demo.Repo.AdmissionRepo;
import com.example.demo.Repo.AssignmentMarkRepo;
import com.example.demo.Repo.SemesterMarkRepo;
import com.example.demo.Repo.SubjectRepo;
import com.example.demo.Repo.TeaacherRepo;
import com.example.demo.Repo.UnitTestRepo;
import com.example.demo.database.AdmissionDetail;
import com.example.demo.database.AssignmentMark;
import com.example.demo.database.SemesterMark;
import com.example.demo.database.SubjectDetail;
import com.example.demo.database.TeacherDetail;
import com.example.demo.database.UnitTestMark;
import com.example.demo.dto.AssignmentMarkDetail;
import com.example.demo.dto.AssignmentMarkRequest;
import com.example.demo.dto.SemesterMarkDetail;
import com.example.demo.dto.SemesterMarkRequest;
import com.example.demo.dto.UnitTestDetail;
import com.example.demo.dto.UnitTestMarkRequest;
import com.example.demo.dto.ViewStudentMarkDto;
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
    AssignmentMarkRepo assignmentMarkRepo;

    @Autowired
    SemesterMarkRepo semesterMarkRepo;


    @Autowired
    SubjectRepo subjectRepo;

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

    @Override
    public void saveAssignmentMark(AssignmentMarkRequest assignmentMarkRequest) {
        TeacherDetail teacherDetail = teaacherRepo.findByEmail(assignmentMarkRequest.getEmail());
        assignmentMarkRequest.getAssignmentMarkList().forEach(assignmentMark -> {
            AssignmentMark assignmentMarkTest = assignmentMarkRepo.findBySubjectNameAndStudentEmailAndStudentName(
                    teacherDetail.getSpc(),
                        assignmentMark.getEmail(),
                    assignmentMark.getName());
            if(ObjectUtils.isEmpty(assignmentMarkTest)) {
                assignmentMarkTest = new AssignmentMark();
                assignmentMarkTest.setSubjectName(teacherDetail.getSpc());
                assignmentMarkTest.setStudentName(assignmentMark.getName());
                assignmentMarkTest.setStudentEmail(assignmentMark.getEmail());
            }
            assignmentMarkTest.setUnitTest1(assignmentMark.getTest1());
            assignmentMarkTest.setUnitTest2(assignmentMark.getTest2());
            assignmentMarkTest.setUnitTest3(assignmentMark.getTest3());
            assignmentMarkRepo.save(assignmentMarkTest);
        });

    }

    @Override
    public List<AssignmentMarkDetail> viewAssignmentMark(String email) {
        TeacherDetail teacherDetail = teaacherRepo.findByEmail(email);
        List<AssignmentMark> assignmentMarkTest = assignmentMarkRepo.findBySubjectName(teacherDetail.getSpc());
        List<AssignmentMarkDetail> AssignmentMarkList = new ArrayList<>();
        if(!ObjectUtils.isEmpty(assignmentMarkTest)) {
            assignmentMarkTest.forEach(
                    unitTestMark -> {
                        AssignmentMarkDetail assignmentMarkDetail = new AssignmentMarkDetail();
                        assignmentMarkDetail.setName(unitTestMark.getStudentName());
                        assignmentMarkDetail.setEmail(unitTestMark.getStudentEmail());
                        assignmentMarkDetail.setTest1(unitTestMark.getUnitTest1());
                        assignmentMarkDetail.setTest2(unitTestMark.getUnitTest2());
                        assignmentMarkDetail.setTest3(unitTestMark.getUnitTest3());
                        AssignmentMarkList.add(assignmentMarkDetail);
                    });
            return AssignmentMarkList;
        } else {
            List<AdmissionDetail> admissionDetailList = admissionRepo.findByIsapprove(true);
            admissionDetailList.forEach(admissionDetail -> {
                AssignmentMarkDetail assignmentMarkDetail = new AssignmentMarkDetail();
                assignmentMarkDetail.setName(admissionDetail.getName());
                assignmentMarkDetail.setEmail(admissionDetail.getEmail());
                assignmentMarkDetail.setTest1(0);
                assignmentMarkDetail.setTest2(0);
                assignmentMarkDetail.setTest3(0);
                AssignmentMarkList.add(assignmentMarkDetail);
            });
            return AssignmentMarkList;
        }
    }

    @Override
    public List<SemesterMarkDetail> viewSemesterMark(String email) {
        TeacherDetail teacherDetail = teaacherRepo.findByEmail(email);
        List<SemesterMark> semesterMarkList = semesterMarkRepo.findBySubjectName(teacherDetail.getSpc());
        List<SemesterMarkDetail> semesterMarkDetails = new ArrayList<>();
        if(!ObjectUtils.isEmpty(semesterMarkList)) {
            semesterMarkList.forEach(
                    semesterMark -> {
                        SemesterMarkDetail semesterMarkDetail = new SemesterMarkDetail();
                        semesterMarkDetail.setName(semesterMark.getStudentName());
                        semesterMarkDetail.setEmail(semesterMark.getStudentEmail());
                        semesterMarkDetail.setMark(semesterMark.getMark());
                        semesterMarkDetails.add(semesterMarkDetail);
                    });
            return semesterMarkDetails;
        } else {
            List<AdmissionDetail> admissionDetailList = admissionRepo.findByIsapprove(true);
            admissionDetailList.forEach(admissionDetail -> {
                SemesterMarkDetail semesterMarkDetail = new SemesterMarkDetail();
                semesterMarkDetail.setName(admissionDetail.getName());
                semesterMarkDetail.setEmail(admissionDetail.getEmail());
                semesterMarkDetail.setMark(0);
                semesterMarkDetails.add(semesterMarkDetail);
            });
            return semesterMarkDetails;
        }
    }

    @Override
    public void saveSemesterMark(SemesterMarkRequest semesterMarkRequest) {
        TeacherDetail teacherDetail = teaacherRepo.findByEmail(semesterMarkRequest.getEmail());
        semesterMarkRequest.getSemesterMarkDetails().forEach(semesterMarkDetail -> {
            SemesterMark semestermark = semesterMarkRepo.findBySubjectNameAndStudentEmailAndStudentName(
                    teacherDetail.getSpc(),
                    semesterMarkDetail.getEmail(),
                    semesterMarkDetail.getName());
            if(ObjectUtils.isEmpty(semestermark)) {
                semestermark = new SemesterMark();
                semestermark.setSubjectName(teacherDetail.getSpc());
                semestermark.setStudentName(semesterMarkDetail.getName());
                semestermark.setStudentEmail(semesterMarkDetail.getEmail());
            }
            semestermark.setMark(semesterMarkDetail.getMark());
            semesterMarkRepo.save(semestermark);
        });
    }

    @Override
    public ViewStudentMarkDto viewStudentMark(String email, String subject) {
        SubjectDetail subjectDetail = subjectRepo.findBySubjectName(subject);
        UnitTestMark unitTestMark = null;
        AssignmentMark assignmentMark = null;
        SemesterMark semesterMark = null;
        if(!ObjectUtils.isEmpty(subjectDetail)) {
            unitTestMark = unitTestRepo.findBySubjectNameAndStudentEmail(subjectDetail.getSubjectCode(),email);
            assignmentMark = assignmentMarkRepo.findBySubjectNameAndStudentEmail(subjectDetail.getSubjectCode(),email);
            semesterMark = semesterMarkRepo.findBySubjectNameAndStudentEmail(subjectDetail.getSubjectCode(),email);
        }
        if(!ObjectUtils.isEmpty(subjectDetail) && !ObjectUtils.isEmpty(unitTestMark) && !ObjectUtils.isEmpty(assignmentMark) && !ObjectUtils.isEmpty(semesterMark)) {
            ViewStudentMarkDto viewStudentMarkDto = new ViewStudentMarkDto();
            viewStudentMarkDto.setUt1(String.valueOf(unitTestMark.getUnitTest1()));
            viewStudentMarkDto.setUt2(String.valueOf(unitTestMark.getUnitTest2()));
            viewStudentMarkDto.setUt3(String.valueOf(unitTestMark.getUnitTest3()));
            Integer tut = unitTestMark.getUnitTest1() + unitTestMark.getUnitTest2() + unitTestMark.getUnitTest3();
            viewStudentMarkDto.setTut(String.valueOf(unitTestMark.getUnitTest1() + unitTestMark.getUnitTest2() + unitTestMark.getUnitTest3()));

            viewStudentMarkDto.setAt1(String.valueOf(assignmentMark.getUnitTest1()));
            viewStudentMarkDto.setAt2(String.valueOf(assignmentMark.getUnitTest2()));
            viewStudentMarkDto.setAt3(String.valueOf(assignmentMark.getUnitTest3()));
            Integer aut = assignmentMark.getUnitTest1() + assignmentMark.getUnitTest2() + assignmentMark.getUnitTest3();
            viewStudentMarkDto.setAut(String.valueOf(assignmentMark.getUnitTest1() + assignmentMark.getUnitTest2() + assignmentMark.getUnitTest3()));

            Integer internal = tut + aut;
            viewStudentMarkDto.setInternal(String.valueOf(internal));
            viewStudentMarkDto.setExternal(String.valueOf(semesterMark.getMark()));
            viewStudentMarkDto.setTotal(String.valueOf(internal+semesterMark.getMark()));
            Integer grade = (internal+semesterMark.getMark())/10;
            viewStudentMarkDto.setGrade(String.valueOf(grade));
            return viewStudentMarkDto;

        }

        ViewStudentMarkDto viewStudentMarkDto = new ViewStudentMarkDto();
        viewStudentMarkDto.setUt1("-");
        viewStudentMarkDto.setUt2("-");
        viewStudentMarkDto.setUt3("-");
        viewStudentMarkDto.setTut("-");

        viewStudentMarkDto.setAt1("-");
        viewStudentMarkDto.setAt2("-");
        viewStudentMarkDto.setAt3("-");
        viewStudentMarkDto.setAut("-");

        viewStudentMarkDto.setInternal("-");
        viewStudentMarkDto.setExternal("-");
        viewStudentMarkDto.setGrade("-");
        return viewStudentMarkDto;




    }
}

package com.example.demo.service;

import com.example.demo.Repo.SubjectRepo;
import com.example.demo.database.SubjectDetail;
import com.example.demo.dto.AddSubjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepo subjectRepo;
    @Override
    public void addSubject(AddSubjectRequest addSubjectRequest) {
        SubjectDetail subjectDetail = subjectRepo.findBySubjectCodeOrSubjectName(addSubjectRequest.getSubjectCode(),addSubjectRequest.getSubjectName());
        if(ObjectUtils.isEmpty(subjectDetail)) {
            SubjectDetail subjectDetail1 = new SubjectDetail();
      subjectDetail1.setSubjectCode(addSubjectRequest.getSubjectCode());
      subjectDetail1.setSubjectName(addSubjectRequest.getSubjectName());
      subjectDetail1.setCredit(addSubjectRequest.getCredit());
      subjectDetail1.setStatusType((byte)1);
      subjectRepo.save(subjectDetail1);
        }

    }

    @Override
    public void deleteSubject(String subjectCode) {
        SubjectDetail subjectDetail=subjectRepo.findBySubjectCode(subjectCode);
        subjectRepo.delete(subjectDetail);
    }

    @Override
    public List<AddSubjectRequest> getSubject() {
        List<SubjectDetail> subjectDetailList = subjectRepo.findAll();
        List<AddSubjectRequest> subjectRequestList = new ArrayList<>();
        subjectDetailList.forEach(subjectDetail -> {
            AddSubjectRequest addSubjectRequest = new AddSubjectRequest();
            addSubjectRequest.setSubjectName(subjectDetail.getSubjectName());
            addSubjectRequest.setSubjectCode(subjectDetail.getSubjectCode());
            addSubjectRequest.setCredit(subjectDetail.getCredit());
            subjectRequestList.add(addSubjectRequest);
        });
        return subjectRequestList;
    }
}

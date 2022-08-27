package com.example.demo.Repo;


import com.example.demo.database.SemesterMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SemesterMarkRepo extends JpaRepository<SemesterMark,Integer> {

    // select * from semester mark where subject name=input;
    List<SemesterMark> findBySubjectName(String subjectCode);

    SemesterMark findBySubjectNameAndStudentEmailAndStudentName(String scode, String email, String name);

    SemesterMark findBySubjectNameAndStudentEmail(String scode,String email);
}

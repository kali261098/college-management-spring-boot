package com.example.demo.Repo;

import com.example.demo.database.UnitTestMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitTestRepo extends JpaRepository<UnitTestMark,Integer> {
    List<UnitTestMark> findBySubjectName(String subjectCode);

    UnitTestMark findBySubjectNameAndStudentEmailAndStudentName(String scode,String email,String name);

    UnitTestMark findBySubjectNameAndStudentEmail(String scode,String email);
}

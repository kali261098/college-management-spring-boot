package com.example.demo.Repo;

import com.example.demo.database.AssignmentMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentMarkRepo extends JpaRepository<AssignmentMark,Integer> {
    List<AssignmentMark> findBySubjectName(String subjectCode);

    AssignmentMark findBySubjectNameAndStudentEmailAndStudentName(String scode, String email, String name);

    AssignmentMark findBySubjectNameAndStudentEmail(String scode,String email);
}

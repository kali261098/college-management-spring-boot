package com.example.demo.Repo;

import com.example.demo.database.SubjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo  extends JpaRepository<SubjectDetail,Integer> {
    SubjectDetail findBySubjectCodeOrSubjectName(String subjectCode,String subjectName);

    SubjectDetail findBySubjectCode(String subjectCode);

    SubjectDetail findBySubjectName(String subjectName);
}

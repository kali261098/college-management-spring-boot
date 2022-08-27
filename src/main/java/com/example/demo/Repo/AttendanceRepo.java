package com.example.demo.Repo;

import com.example.demo.database.Attendance;
import com.example.demo.database.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance,Integer> {
  // select * from attendace where name="input" and email="input" and subject_name="input";
    Attendance findBySubjectNameAndStudentEmailAndStudentName(String spc, String email, String name);

  List<Attendance> findBySubjectNameAndDate(String spc, Date date);
}

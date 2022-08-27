package com.example.demo.Repo;

import com.example.demo.database.Attendance;
import com.example.demo.database.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance,Integer> {
  // select * from attendace where name="input" and email="input" and subject_name="input";
    Attendance findBySubjectNameAndStudentEmailAndStudentName(String spc, String email, String name);
}

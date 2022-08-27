package com.example.demo.service;

import com.example.demo.Repo.AttendanceRepo;
import com.example.demo.Repo.TeaacherRepo;
import com.example.demo.database.Attendance;
import com.example.demo.database.SemesterMark;
import com.example.demo.database.TeacherDetail;
import com.example.demo.dto.AttendanceDaily;
import com.example.demo.dto.AttendanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AttendanceService {
@Autowired
TeaacherRepo teacherRepo;
@Autowired
    AttendanceRepo attendanceRepo;

    public void attendance(AttendanceRequest attendanceRequest) {
        TeacherDetail teacherDetail = teacherRepo.findByEmail(attendanceRequest.getTeacherEmail());
        attendanceRequest.getAttendanceDailyList().forEach(attendanceDaily -> {
            Attendance attendance = attendanceRepo.findBySubjectNameAndStudentEmailAndStudentName(
                    teacherDetail.getSpc(),
                    attendanceDaily.getEmail(),
                    attendanceDaily.getName());

            if(ObjectUtils.isEmpty(attendance)) {
                attendance = new Attendance();
                attendance.setSubjectName(teacherDetail.getSpc());
                attendance.setStudentName(attendanceDaily.getName());
                attendance.setStudentEmail(attendanceDaily.getEmail());

            }
            attendance.setDate(attendanceRequest.getDate());
            attendance.setAttendanceStatus(attendanceDaily.isAttendance());
            attendanceRepo.save(attendance);
        });
    }
}

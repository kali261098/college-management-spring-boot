package com.example.demo.service;

import com.example.demo.Repo.AdmissionRepo;
import com.example.demo.Repo.AttendanceRepo;
import com.example.demo.Repo.TeaacherRepo;
import com.example.demo.database.AdmissionDetail;
import com.example.demo.database.Attendance;
import com.example.demo.database.SemesterMark;
import com.example.demo.database.TeacherDetail;
import com.example.demo.dto.AttendanceDaily;
import com.example.demo.dto.AttendanceRequest;
import com.example.demo.dto.SemesterMarkDetail;
import com.example.demo.dto.StudentAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {
@Autowired
TeaacherRepo teacherRepo;
@Autowired
    AttendanceRepo attendanceRepo;
@Autowired
    AdmissionRepo admissionRepo;

    public void attendance(AttendanceRequest attendanceRequest) {
        TeacherDetail teacherDetail = teacherRepo.findByEmail(attendanceRequest.getTeacherEmail());
        attendanceRequest.getAttendanceDailyList().forEach(attendanceDaily -> {
            Attendance attendance = attendanceRepo.findBySubjectNameAndStudentEmailAndDate(
                    teacherDetail.getSpc(),
                    attendanceDaily.getEmail(),
                    attendanceRequest.getDate());

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

    public List<AttendanceDaily> viewAttendance(String email, Date date) {
        TeacherDetail teacherDetail = teacherRepo.findByEmail(email);
        List<Attendance> attendanceList = attendanceRepo.findBySubjectNameAndDate(teacherDetail.getSpc(),date);
        List<AttendanceDaily> attendanceDailyList = new ArrayList<>();
        if(!ObjectUtils.isEmpty(attendanceList)) {
            attendanceList.forEach(
                    attendance -> {
                      AttendanceDaily attendanceDaily = new AttendanceDaily();
                        attendanceDaily.setName(attendance.getStudentName());
                        attendanceDaily.setEmail(attendance.getStudentEmail());
                        attendanceDaily.setAttendance(attendance.isAttendanceStatus());
                        attendanceDailyList.add(attendanceDaily);
                    });
            return attendanceDailyList;
        } else {
            List<AdmissionDetail> admissionDetailList = admissionRepo.findByIsapprove(true);
            admissionDetailList.forEach(admissionDetail -> {
                AttendanceDaily attendanceDaily = new AttendanceDaily();
                attendanceDaily.setName(admissionDetail.getName());
                attendanceDaily.setEmail(admissionDetail.getEmail());
                attendanceDaily.setAttendance(false);
                attendanceDailyList.add(attendanceDaily);
            });
            return attendanceDailyList;
        }
    }

    public StudentAttendance studentAttendance(String email, String subject) {
        List<Attendance> attendanceList = attendanceRepo.findByStudentEmailAndSubjectName(email,subject);
        StudentAttendance studentAttendances = new StudentAttendance();
        int present=0;
        int absent = 0;
        List<Date> absentList = new ArrayList<>();
        if(!ObjectUtils.isEmpty(attendanceList)) {
            for (Attendance attendance :attendanceList ) {
                if(attendance.isAttendanceStatus()){
                    present=present+1;
                }else {
                    absentList.add(attendance.getDate());
                }

            }
            absent = attendanceList.size()-present;
        }
        int total = present+absent;
        int percentage=0;
        if(total!=0){
            percentage = present*100/total;
        }

        studentAttendances.setAbsent(absent);
        studentAttendances.setPercentage(percentage);
        studentAttendances.setPresent(present);
        studentAttendances.setTotal(total);
        studentAttendances.setAbsentList(absentList);
        return studentAttendances;

    }
}

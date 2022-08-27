package com.example.demo.database;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="attendance")
@Entity
@ToString

public class Attendance {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="student_name")
    private String studentName;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "date")
    private Date date;
    @Column(name = "attendance_status")
    private boolean attendanceStatus;

}

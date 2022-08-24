package com.example.demo.database;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="semester_mark")
@Entity
@ToString
public class SemesterMark {
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
    @Column(name = "mark")
    private Integer mark;
}

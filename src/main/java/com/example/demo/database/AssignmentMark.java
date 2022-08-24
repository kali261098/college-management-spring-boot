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
@Table(name ="assignment_mark")
@Entity
@ToString
public class AssignmentMark {
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
    @Column(name = "unit_test_1")
    private Integer unitTest1;
    @Column(name = "unit_test_2")
    private Integer unitTest2;
    @Column(name = "unit_test_3")
    private Integer unitTest3;

}

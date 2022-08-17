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
@Table(name ="subject_detail")
@Entity
@ToString
public class SubjectDetail {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="subject_name")
    private String subjectName;
    @Column(name = "subject_code")
    private String subjectCode;
    @Column(name = "credit")
    private Integer credit;
    @Column(name = "status_type")
    private Byte statusType;
}

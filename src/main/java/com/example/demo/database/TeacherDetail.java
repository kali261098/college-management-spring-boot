package com.example.demo.database;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="teacher_detail")
@Entity
@ToString
public class TeacherDetail {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name= "dob")
    private String dob;
    @Column(name= "address")
    private String address;
    @Column(name="gender")
    private String gender;
    @Column(name= "highest_degree")
    private String degree;
    @Column(name= "experience")
    private String exp;
    @Column(name= "subject")
    private String spc;


}

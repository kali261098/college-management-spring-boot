package com.example.demo.database;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="admission_detail")
@Entity
@ToString
public class AdmissionDetail {
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
    @Column(name= "ug_college_name")
    private String ug;
    @Column(name= "ug_percentage")
    private String ugper;
    @Column(name= "hsc")
    private String hsc;
    @Column(name= "hsc_percentage")
    private String hscper;
    @Column(name= "sslc")
    private String sslc;
    @Column(name= "sslc_percentage")
    private String sslcper;
    @Column(name="is_approved")
    private Boolean isapprove;

}

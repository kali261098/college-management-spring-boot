package com.example.demo.Repo;

import com.example.demo.database.AdmissionDetail;
import com.example.demo.database.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionRepo  extends JpaRepository<AdmissionDetail,Integer> {
    //select all from admission detail table ;
    List<AdmissionDetail> findAll();
    AdmissionDetail findByEmail(String email);
}

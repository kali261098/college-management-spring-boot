package com.example.demo.Repo;

import com.example.demo.database.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaacherRepo extends JpaRepository<TeacherDetail,Integer> {
    TeacherDetail findByEmail(String email);

}

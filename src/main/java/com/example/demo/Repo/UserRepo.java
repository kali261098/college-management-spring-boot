package com.example.demo.Repo;

import com.example.demo.database.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    // select * from user where email=:email
    List<User> findByEmail(String email);
}

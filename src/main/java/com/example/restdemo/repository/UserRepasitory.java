package com.example.restdemo.repository;

import com.example.restdemo.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepasitory extends JpaRepository<User,Long> {
}

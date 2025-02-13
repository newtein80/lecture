package com.mobigen.lecture.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobigen.lecture.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}

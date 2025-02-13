package com.mobigen.lecture.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobigen.lecture.user.entity.User;
import com.mobigen.lecture.user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // 사용자 등록
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 조회
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // 이메일로 사용자 조회
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // 사용자 수정
    public User updateUser(Integer id, User userDetails) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;
    }
}

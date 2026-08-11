package com.swati.ai_mock_interview_backend.service;

import com.swati.ai_mock_interview_backend.entity.User;
import com.swati.ai_mock_interview_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }
}
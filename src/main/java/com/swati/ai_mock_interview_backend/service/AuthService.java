package com.swati.ai_mock_interview_backend.service;

import com.swati.ai_mock_interview_backend.dto.LoginRequest;
import com.swati.ai_mock_interview_backend.dto.LoginResponse;
import com.swati.ai_mock_interview_backend.entity.User;
import com.swati.ai_mock_interview_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return new LoginResponse(
                "Login Successful",
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
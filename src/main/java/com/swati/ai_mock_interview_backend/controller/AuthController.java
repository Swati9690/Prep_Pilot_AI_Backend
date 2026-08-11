package com.swati.ai_mock_interview_backend.controller;

import com.swati.ai_mock_interview_backend.dto.LoginRequest;
import com.swati.ai_mock_interview_backend.dto.LoginResponse;
import com.swati.ai_mock_interview_backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
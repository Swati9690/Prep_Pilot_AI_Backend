package com.swati.ai_mock_interview_backend.controller;

import com.swati.ai_mock_interview_backend.dto.DashboardResponse;
import com.swati.ai_mock_interview_backend.entity.Interview;
import com.swati.ai_mock_interview_backend.service.InterviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin("*")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping
    public Interview submitInterview(@RequestBody Interview interview) {
        return interviewService.submitInterview(interview);
    }

    @GetMapping("/user/{userId}")
    public List<Interview> getUserInterviews(@PathVariable Long userId) {
        return interviewService.getUserInterviews(userId);
    }

    @GetMapping("/dashboard/{userId}")
    public DashboardResponse getDashboard(@PathVariable Long userId) {
        return interviewService.getDashboard(userId);
    }
}
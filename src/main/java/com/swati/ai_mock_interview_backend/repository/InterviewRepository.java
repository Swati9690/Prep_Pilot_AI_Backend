package com.swati.ai_mock_interview_backend.repository;

import com.swati.ai_mock_interview_backend.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    List<Interview> findByUserId(Long userId);

    long countByUserId(Long userId);

    Optional<Interview> findTopByUserIdOrderByIdDesc(Long userId);

    List<Interview> findByUserIdAndScoreIsNotNull(Long userId);
}
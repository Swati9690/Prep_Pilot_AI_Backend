package com.swati.ai_mock_interview_backend.repository;

import com.swati.ai_mock_interview_backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository
        extends JpaRepository<Question, Long> {


    // GET BY TECHNOLOGY


    List<Question> findByTechnology(
            String technology
    );



    // GET BY TECHNOLOGY + DIFFICULTY


    List<Question> findByTechnologyAndDifficulty(
            String technology,
            String difficulty
    );



    // GET BY CATEGORY


    List<Question> findByCategory(
            String category
    );



    // GET BY QUESTION TYPE


    List<Question> findByQuestionType(
            String questionType
    );



    // GET BY TECHNOLOGY + QUESTION TYPE


    List<Question> findByTechnologyAndQuestionType(
            String technology,
            String questionType
    );



    // FIND QUESTION BY TEXT


    Optional<Question> findByQuestion(
            String question
    );



    // GET RANDOM QUESTIONS


    @Query("""
        SELECT q
        FROM Question q
        WHERE q.technology = :technology
        AND q.difficulty = :difficulty
        ORDER BY RAND()
    """)
    List<Question> findRandomQuestions(
            @Param("technology") String technology,
            @Param("difficulty") String difficulty
    );
}
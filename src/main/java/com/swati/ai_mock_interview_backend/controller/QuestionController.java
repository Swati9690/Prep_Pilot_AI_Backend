package com.swati.ai_mock_interview_backend.controller;

import com.swati.ai_mock_interview_backend.entity.Question;
import com.swati.ai_mock_interview_backend.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin("*")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(
            QuestionService questionService) {

        this.questionService =
                questionService;
    }

    // GET ALL QUESTIONS

    @GetMapping
    public List<Question> getAllQuestions() {

        return questionService
                .getAllQuestions();
    }

    // ADD QUESTION

    @PostMapping
    public Question addQuestion(
            @RequestBody Question question) {

        return questionService
                .addQuestion(question);
    }

    // GET BY TECHNOLOGY

    @GetMapping("/technology/{technology}")
    public List<Question> getByTechnology(
            @PathVariable String technology) {

        return questionService
                .getByTechnology(
                        technology
                );
    }

    // GET BY TECHNOLOGY + DIFFICULTY

    @GetMapping("/filter")
    public List<Question> getFilteredQuestions(

            @RequestParam String technology,

            @RequestParam String difficulty) {

        return questionService
                .getByTechnologyAndDifficulty(
                        technology,
                        difficulty
                );
    }

    // GET BY CATEGORY

    @GetMapping("/category/{category}")
    public List<Question> getByCategory(
            @PathVariable String category) {

        return questionService
                .getByCategory(
                        category
                );
    }

    // GET BY QUESTION TYPE

    @GetMapping("/type/{questionType}")
    public List<Question> getByQuestionType(
            @PathVariable String questionType) {

        return questionService
                .getByQuestionType(
                        questionType
                );
    }

    // RANDOM QUESTIONS

    @GetMapping("/random")
    public List<Question> getRandomQuestions(

            @RequestParam String technology,

            @RequestParam String difficulty,

            @RequestParam(
                    defaultValue = "10"
            )
            int limit) {

        return questionService
                .getRandomQuestions(
                        technology,
                        difficulty,
                        limit
                );
    }
}
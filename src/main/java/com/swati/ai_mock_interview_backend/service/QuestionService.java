package com.swati.ai_mock_interview_backend.service;

import com.swati.ai_mock_interview_backend.entity.Question;
import com.swati.ai_mock_interview_backend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(
            QuestionRepository questionRepository) {

        this.questionRepository =
                questionRepository;
    }


    // GET ALL QUESTIONS


    public List<Question> getAllQuestions() {

        return questionRepository.findAll();
    }


    // ADD QUESTION

    public Question addQuestion(
            Question question) {

        return questionRepository.save(
                question
        );
    }


    // GET BY TECHNOLOGY

    public List<Question> getByTechnology(
            String technology) {

        return questionRepository
                .findByTechnology(
                        technology
                );
    }


    // GET BY TECHNOLOGY + DIFFICULTY


    public List<Question> getByTechnologyAndDifficulty(
            String technology,
            String difficulty) {

        return questionRepository
                .findByTechnologyAndDifficulty(
                        technology,
                        difficulty
                );
    }


    // GET BY CATEGORY

    public List<Question> getByCategory(
            String category) {

        return questionRepository
                .findByCategory(
                        category
                );
    }


    // GET BY QUESTION TYPE


    public List<Question> getByQuestionType(
            String questionType) {

        return questionRepository
                .findByQuestionType(
                        questionType
                );
    }


    // GET BY TECHNOLOGY + QUESTION TYPE


    public List<Question> getByTechnologyAndType(
            String technology,
            String questionType) {

        return questionRepository
                .findByTechnologyAndQuestionType(
                        technology,
                        questionType
                );
    }

    // RANDOM QUESTIONS


    public List<Question> getRandomQuestions(
            String technology,
            String difficulty) {

        List<Question> questions =
                questionRepository
                        .findRandomQuestions(
                                technology,
                                difficulty
                        );

        return removeDuplicateQuestions(
                questions
        );
    }


    // RANDOM LIMITED QUESTIONS


    public List<Question> getRandomQuestions(
            String technology,
            String difficulty,
            int limit) {


        if (limit <= 0) {
            return new ArrayList<>();
        }


        // GET ALL QUESTIONS FOR TECHNOLOGY + DIFFICULTY


        List<Question> questions =
                questionRepository
                        .findByTechnologyAndDifficulty(
                                technology,
                                difficulty
                        );


        // REMOVE DUPLICATES


        List<Question> uniqueQuestions =
                removeDuplicateQuestions(
                        questions
                );


        // SHUFFLE


        Collections.shuffle(
                uniqueQuestions
        );


        // RETURN EXACT LIMIT


        if (uniqueQuestions.size() <= limit) {

            return uniqueQuestions;
        }

        return new ArrayList<>(
                uniqueQuestions.subList(
                        0,
                        limit
                )
        );
    }

    // REMOVE DUPLICATE QUESTIONS

    private List<Question> removeDuplicateQuestions(
            List<Question> questions) {

        if (questions == null ||
                questions.isEmpty()) {

            return new ArrayList<>();
        }



        Map<String, Question> uniqueMap =
                new LinkedHashMap<>();

        for (Question question : questions) {

            if (question == null) {
                continue;
            }

            String questionText =
                    question.getQuestion();

            if (questionText == null ||
                    questionText.trim().isEmpty()) {

                continue;
            }



            String normalizedQuestion =
                    questionText
                            .trim()
                            .replaceAll(
                                    "\\s+",
                                    " "
                            )
                            .toLowerCase();

            uniqueMap.putIfAbsent(
                    normalizedQuestion,
                    question
            );
        }

        return new ArrayList<>(
                uniqueMap.values()
        );
    }
}
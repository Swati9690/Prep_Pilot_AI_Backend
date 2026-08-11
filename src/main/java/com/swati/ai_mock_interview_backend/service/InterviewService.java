package com.swati.ai_mock_interview_backend.service;

import com.swati.ai_mock_interview_backend.dto.DashboardResponse;
import com.swati.ai_mock_interview_backend.entity.Interview;
import com.swati.ai_mock_interview_backend.entity.Question;
import com.swati.ai_mock_interview_backend.repository.InterviewRepository;
import com.swati.ai_mock_interview_backend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final QuestionRepository questionRepository;
    private final AiEvaluationService aiEvaluationService;

    public InterviewService(
            InterviewRepository interviewRepository,
            QuestionRepository questionRepository,
            AiEvaluationService aiEvaluationService) {

        this.interviewRepository = interviewRepository;
        this.questionRepository = questionRepository;
        this.aiEvaluationService = aiEvaluationService;
    }


    // SUBMIT INTERVIEW


    public Interview submitInterview(Interview interview) {


        // GET ACTUAL QUESTION


        String questionText = interview.getQuestion();

        // If frontend sends questionId, get question from database
        if (interview.getQuestionId() != null) {

            Question question =
                    questionRepository
                            .findById(interview.getQuestionId())
                            .orElse(null);

            if (question != null) {

                questionText =
                        question.getQuestion();

                // Keep technology/difficulty in sync
                if (interview.getTechnology() == null) {

                    interview.setTechnology(
                            question.getTechnology()
                    );
                }

                if (interview.getDifficulty() == null) {

                    interview.setDifficulty(
                            question.getDifficulty()
                    );
                }
            }
        }


        // QUESTION NOT FOUND


        if (questionText == null ||
                questionText.trim().isEmpty()) {

            interview.setScore(0);

            interview.setFeedback(
                    "Score: 0/100. "
                            + "Question information is missing. "
                            + "Please select a valid interview question."
            );

            return interviewRepository.save(interview);
        }


        // SAVE ACTUAL QUESTION TEXT


        interview.setQuestion(questionText);


        // AI EVALUATION


        String evaluation =
                aiEvaluationService.evaluateAnswer(
                        questionText,
                        interview.getAnswer()
                );


        // EXTRACT SCORE


        int score =
                extractScore(evaluation);


        // SAVE SCORE + FEEDBACK


        interview.setScore(score);
        interview.setFeedback(evaluation);

        return interviewRepository.save(interview);
    }


    // GET USER INTERVIEWS


    public List<Interview> getUserInterviews(Long userId) {

        return interviewRepository.findByUserId(userId);
    }


    // GET DASHBOARD


    public DashboardResponse getDashboard(Long userId) {

        List<Interview> interviews =
                interviewRepository.findByUserId(userId);


        // NO INTERVIEWS


        if (interviews == null ||
                interviews.isEmpty()) {

            return new DashboardResponse(
                    0,
                    0.0,
                    null
            );
        }


        // TOTAL INTERVIEWS

        long totalInterviews =
                interviews.size();


        // AVERAGE SCORE


        double totalScore = 0;

        int scoredInterviews = 0;

        for (Interview interview : interviews) {

            if (interview.getScore() != null) {

                totalScore +=
                        interview.getScore();

                scoredInterviews++;
            }
        }

        double averageScore = 0.0;

        if (scoredInterviews > 0) {

            averageScore =
                    totalScore / scoredInterviews;
        }


        // LATEST SCORE

        Integer latestScore = null;

        Interview latestInterview =
                interviews.stream()

                        .filter(interview ->
                                interview.getScore() != null)

                        .max(
                                Comparator.comparing(
                                        Interview::getId,
                                        Comparator.nullsFirst(
                                                Comparator.naturalOrder()
                                        )
                                )
                        )

                        .orElse(null);

        if (latestInterview != null) {

            latestScore =
                    latestInterview.getScore();
        }


        // RETURN DASHBOARD

        return new DashboardResponse(
                totalInterviews,
                averageScore,
                latestScore
        );
    }

    // EXTRACT SCORE FROM AI RESPONSE


    private int extractScore(String evaluation) {

        if (evaluation == null ||
                evaluation.isEmpty()) {

            return 0;
        }

        try {

            int start =
                    evaluation.indexOf("Score: ") + 7;

            int end =
                    evaluation.indexOf("/100");

            if (start >= 7 &&
                    end > start) {

                String scoreText =
                        evaluation
                                .substring(
                                        start,
                                        end
                                )
                                .trim();

                return Integer.parseInt(
                        scoreText
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Unable to extract score from evaluation: "
                            + evaluation
            );
        }

        return 0;
    }
}
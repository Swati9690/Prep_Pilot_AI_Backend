package com.swati.ai_mock_interview_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    // ID of the question from questions table
    private Long questionId;

    @Column(length = 2000)
    private String question;

    @Column(length = 5000)
    private String answer;

    private Integer score;

    @Column(length = 5000)
    private String feedback;

    private String technology;

    private String difficulty;

    public Interview() {
    }


    // GET ID


    public Long getId() {
        return id;
    }


    // SET ID


    public void setId(Long id) {
        this.id = id;
    }


    // GET USER ID


    public Long getUserId() {
        return userId;
    }

    // SET USER ID


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    // GET QUESTION ID


    public Long getQuestionId() {
        return questionId;
    }

    // SET QUESTION ID

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }


    // GET QUESTION

    public String getQuestion() {
        return question;
    }


    // SET QUESTION


    public void setQuestion(String question) {
        this.question = question;
    }


    // GET ANSWER


    public String getAnswer() {
        return answer;
    }


    // SET ANSWER


    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // GET SCORE

    public Integer getScore() {
        return score;
    }


    // SET SCORE


    public void setScore(Integer score) {
        this.score = score;
    }


    // GET FEEDBACK


    public String getFeedback() {
        return feedback;
    }


    // SET FEEDBACK


    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    // GET TECHNOLOGY


    public String getTechnology() {
        return technology;
    }


    // SET TECHNOLOGY


    public void setTechnology(String technology) {
        this.technology = technology;
    }


    // GET DIFFICULTY


    public String getDifficulty() {
        return difficulty;
    }


    // SET DIFFICULTY


    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
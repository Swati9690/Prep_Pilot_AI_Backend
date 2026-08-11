package com.swati.ai_mock_interview_backend.dto;

public class DashboardResponse {

    private long totalInterviews;
    private double averageScore;
    private Integer latestScore;

    public DashboardResponse() {
    }

    public DashboardResponse(
            long totalInterviews,
            double averageScore,
            Integer latestScore) {

        this.totalInterviews = totalInterviews;
        this.averageScore = averageScore;
        this.latestScore = latestScore;
    }

    public long getTotalInterviews() {
        return totalInterviews;
    }

    public void setTotalInterviews(long totalInterviews) {
        this.totalInterviews = totalInterviews;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getLatestScore() {
        return latestScore;
    }

    public void setLatestScore(Integer latestScore) {
        this.latestScore = latestScore;
    }
}
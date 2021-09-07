package com.example.QualityFeedback;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FeedbackTotal {

// Autowiring the repository of feedback objects, making it available for all controller methods in this class.
    @Autowired
    private FeedbackRepository feedbackRepository;

    Integer aprilTotal;
    Integer mayTotal;
    Integer juneTotal;
    Integer julyTotal;
    Integer augustTotal;
    Integer septemberTotal;

    public FeedbackTotal(List<Feedback> feedbacks) {

        Integer aprilTotal = 0;
        Integer mayTotal = 0;
        Integer juneTotal = 0;
        Integer julyTotal = 0;
        Integer augustTotal = 0;
        Integer septemberTotal = 0;

        String month;
        for (Feedback feedback:feedbacks) {
            month = feedback.dateSubmitted.substring(5,7);
            switch(month) {
                case "04":
                    aprilTotal++;
                    break;
                case "05":
                    mayTotal++;
                    break;
                case "06":
                    juneTotal++;
                    break;
                case "07":
                    julyTotal++;
                    break;
                case "08":
                    augustTotal++;
                    break;
                case "09":
                    septemberTotal++;
            }
        }

        this.aprilTotal = aprilTotal;
        this.mayTotal = mayTotal;
        this.juneTotal = juneTotal;
        this.julyTotal = julyTotal;
        this.augustTotal = augustTotal;
        this.septemberTotal = septemberTotal;
    }

    public FeedbackRepository getFeedbackRepository() {
        return feedbackRepository;
    }

    public void setFeedbackRepository(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Integer getAprilTotal() {
        return aprilTotal;
    }

    public void setAprilTotal(Integer aprilTotal) {
        this.aprilTotal = aprilTotal;
    }

    public Integer getMayTotal() {
        return mayTotal;
    }

    public void setMayTotal(Integer mayTotal) {
        this.mayTotal = mayTotal;
    }

    public Integer getJuneTotal() {
        return juneTotal;
    }

    public void setJuneTotal(Integer juneTotal) {
        this.juneTotal = juneTotal;
    }

    public Integer getJulyTotal() {
        return julyTotal;
    }

    public void setJulyTotal(Integer julyTotal) {
        this.julyTotal = julyTotal;
    }

    public Integer getAugustTotal() {
        return augustTotal;
    }

    public void setAugustTotal(Integer augustTotal) {
        this.augustTotal = augustTotal;
    }

    public Integer getSeptemberTotal() {
        return septemberTotal;
    }

    public void setSeptemberTotal(Integer septemberTotal) {
        this.septemberTotal = septemberTotal;
    }
}


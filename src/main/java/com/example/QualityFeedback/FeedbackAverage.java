package com.example.QualityFeedback;

import java.util.List;

public class FeedbackAverage {
    Double colorAverage;
    Double seamAverage;
    Double printAverage;
    Double shrinkageAverage;
    Double materialAverage;
    Integer noOfFeedbacks;

    public FeedbackAverage(List<Feedback> feedbacks) {
        Integer colorSum = 0;
        Integer seamSum = 0;
        Integer printSum = 0;
        Integer shrinkageSum = 0;
        Integer materialSum = 0;

        for (Feedback feedback:feedbacks) {
            colorSum = colorSum + feedback.color;
            seamSum = seamSum  + feedback.seam;
            printSum = printSum + feedback.print;
            shrinkageSum = shrinkageSum + feedback.shrinkage;
            materialSum = materialSum + feedback.material;
        }

        this.noOfFeedbacks = feedbacks.size();
        this.colorAverage = Double.valueOf(colorSum)/this.noOfFeedbacks;
        this.seamAverage = Double.valueOf(seamSum)/this.noOfFeedbacks;
        this.printAverage = Double.valueOf(printSum)/this.noOfFeedbacks;
        this.shrinkageAverage = Double.valueOf(shrinkageSum)/this.noOfFeedbacks;
        this.materialAverage = Double.valueOf(materialSum)/this.noOfFeedbacks;
    }

    public Double getColorAverage() {
        return colorAverage;
    }

    public void setColorAverage(Double colorAverage) {
        this.colorAverage = colorAverage;
    }

    public Double getSeamAverage() {
        return seamAverage;
    }

    public void setSeamAverage(Double seamAverage) {
        this.seamAverage = seamAverage;
    }

    public Double getPrintAverage() {
        return printAverage;
    }

    public void setPrintAverage(Double printAverage) {
        this.printAverage = printAverage;
    }

    public Double getShrinkageAverage() {
        return shrinkageAverage;
    }

    public void setShrinkageAverage(Double shrinkageAverage) {
        this.shrinkageAverage = shrinkageAverage;
    }

    public Double getMaterialAverage() {
        return materialAverage;
    }

    public void setMaterialAverage(Double materialAverage) {
        this.materialAverage = materialAverage;
    }

    public Integer getNoOfFeedbacks() {
        return noOfFeedbacks;
    }

    public void setNoOfFeedbacks(Integer noOfFeedbacks) {
        this.noOfFeedbacks = noOfFeedbacks;
    }
}

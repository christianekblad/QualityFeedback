package com.example.QualityFeedback;

import java.util.List;

public class FeedbackAverage {
    String colorAverage;
    String seamAverage;
    String printAverage;
    String shrinkageAverage;
    String materialAverage;
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

        Double colorAverageDouble = Double.valueOf(colorSum)/this.noOfFeedbacks;
        this.colorAverage = String.format("%.2f", Math.round(colorAverageDouble * 100.0)/100.0).replace(",", ".");

        Double seamAverageDouble = Double.valueOf(seamSum)/this.noOfFeedbacks;
        this.seamAverage = String.format("%.2f", Math.round(seamAverageDouble * 100.0)/100.0).replace(",", ".");

        Double printAverageDouble = Double.valueOf(printSum)/this.noOfFeedbacks;
        this.printAverage = String.format("%.2f", Math.round(printAverageDouble * 100.0)/100.0).replace(",", ".");

        Double shrinkageAverageDouble = Double.valueOf(shrinkageSum)/this.noOfFeedbacks;
        this.shrinkageAverage = String.format("%.2f", Math.round(shrinkageAverageDouble * 100.0)/100.0).replace(",", ".");

        Double materialAverageDouble = Double.valueOf(materialSum)/this.noOfFeedbacks;
        this.materialAverage = String.format("%.2f", Math.round(materialAverageDouble * 100.0)/100.0).replace(",", ".");
    }


    public String getColorAverage() {
        return colorAverage;
    }

    public void setColorAverage(String colorAverage) {
        this.colorAverage = colorAverage;
    }

    public String getSeamAverage() { return seamAverage; }

    public void setSeamAverage(String seamAverage) {
        this.seamAverage = seamAverage;
    }

    public String getPrintAverage() {
        return printAverage;
    }

    public void setPrintAverage(String printAverage) {
        this.printAverage = printAverage;
    }

    public String getShrinkageAverage() {
        return shrinkageAverage;
    }

    public void setShrinkageAverage(String shrinkageAverage) {
        this.shrinkageAverage = shrinkageAverage;
    }

    public String getMaterialAverage() {
        return materialAverage;
    }

    public void setMaterialAverage(String materialAverage) {
        this.materialAverage = materialAverage;
    }

    public Integer getNoOfFeedbacks() {
        return noOfFeedbacks;
    }

    public void setNoOfFeedbacks(Integer noOfFeedbacks) {
        this.noOfFeedbacks = noOfFeedbacks;
    }
}
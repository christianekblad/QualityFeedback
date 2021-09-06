package com.example.QualityFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class QualityFeedbackController {

// Autowiring the repository of feedback objects, making it available for all controller methods in this class.
    @Autowired
    private FeedbackRepository feedbackRepository;

// Initial page for the Quality Feedback application
    @GetMapping("/")
    public String first(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "index";
    }

// Form for customers to enter Quality feedback for H&M's products.
    @GetMapping("/form")
    public String add(Model model) {
        Feedback feedback = new Feedback();
        feedback.ageOfGarment = "0-3";
        feedback.levelOfUse = "Never";
        model.addAttribute("feedback", feedback);
        return "form";
    }

// Page listing all received Quality feedback.
    @GetMapping("/feedbacks")
    public String feedbacks(Model model) {
        List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedbacks";
    }

// Page listing all received Quality feedback for a selected Product number.
    @GetMapping("/feedbacksByProductID")
    public String feedbacksByProductID(Model model, @RequestParam String productNumber) {
        List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findByproductNumberEquals(productNumber);
        model.addAttribute("productNumber", productNumber);
        FeedbackAverage feedbackAverage = new FeedbackAverage(feedbacks);
        model.addAttribute("feedbackAverage", feedbackAverage);
//      return "feedbacks";
        return "feedbackchart";
    }

// Saving Quality feedback entered for an H&M product
    @PostMapping("/saveFeedback")
    public String set(@ModelAttribute Feedback feedback) {
        feedback.setDateSubmitted(LocalDate.now().toString());
        if (feedback.productNumber.length() == 7){
            feedbackRepository.save(feedback);
            return "thankyou";
        }
        return "redirect:/form";
    }

// Admin user login out
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }
}

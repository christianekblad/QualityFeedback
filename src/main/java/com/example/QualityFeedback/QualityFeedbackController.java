package com.example.QualityFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("feedback", new Feedback());
        return "form";
    }

// Page listing all received Quality feedback.
    @GetMapping("/feedbacks")
    public String feedbacks(Model model) {
        List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedbacks";
    }

    @GetMapping("/feedbacksByProductID")
    public String feedbacksByProductID(Model model) {
        List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findByproductNumberEquals(123);
        model.addAttribute("feedbacks", feedbacks);
        return "feedbacks";
    }

// Saving Quality feedback entered for an H&M product
    @PostMapping("/saveFeedback")
    public String set(@ModelAttribute Feedback feedback) {
        feedback.setDateSubmitted(LocalDate.now().toString());
        feedbackRepository.save(feedback);
        return "thankYou";
    }

// Do not think we need this ????????????????????????????????????????????????????????????????
    @GetMapping("/edit/{id}") // used when the edit link is clicked
    public String edit(Model model, @PathVariable Long id) {
        Feedback feedback = feedbackRepository.findById(id).get();
        model.addAttribute(feedback);
        return "form";
    }

// Admin user login out
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }
}

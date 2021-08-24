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

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/")
    public String first(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "index";
    }

    @GetMapping("/form")
    public String add(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "form";
    }

    @GetMapping("/feedbacks")
    public String feedbacks(Model model) {
        List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedbacks";
    }

    @PostMapping("/saveFeedback")
    public String set(@ModelAttribute Feedback feedback) {
        feedback.setDateSubmitted(LocalDate.now().toString());
        feedbackRepository.save(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/edit/{id}") // used when the edit link is clicked
    public String edit(Model model, @PathVariable Long id) {
        Feedback feedback = feedbackRepository.findById(id).get();
        model.addAttribute(feedback);
        return "form";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }
}

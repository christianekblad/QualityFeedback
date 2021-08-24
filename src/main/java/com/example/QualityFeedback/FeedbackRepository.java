package com.example.QualityFeedback;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    List<Feedback> findAll();
}
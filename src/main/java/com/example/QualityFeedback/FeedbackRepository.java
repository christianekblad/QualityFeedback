package com.example.QualityFeedback;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

// Repository holding all Quality feedback records from the database

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    List<Feedback> findAll();

    List<Feedback> findByproductNumberEquals(String i);



}
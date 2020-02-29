package com.example.orderservice.controller;

import com.example.orderservice.exception.ReviewNotFoundException;
import com.example.orderservice.model.Review;
import com.example.orderservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @GetMapping("/{id}")
    public Optional<Review> findReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (!review.isPresent()) {
            throw new ReviewNotFoundException("id - " + id);
        }
        return reviewRepository.findById(id);
    }
}

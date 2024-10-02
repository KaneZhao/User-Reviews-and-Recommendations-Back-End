package com.example.yelp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.yelp.dto.UserReviewDTO;
import com.example.yelp.repositories.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<UserReviewDTO> findReviewWithReviewDetails(String reviewId){
        return reviewRepository.findReviewWithReviewDetails(reviewId);
    }
    
}

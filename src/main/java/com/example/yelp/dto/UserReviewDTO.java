package com.example.yelp.dto;

import java.util.Map;

import lombok.Data;

@Data
public class UserReviewDTO {
    private Map<String, Integer> votes; 
    private String userId; 
    private String reviewId; 
    private Double stars; 
    private String date; 
    private String text; 
    private String type; 
    private String userName;
}

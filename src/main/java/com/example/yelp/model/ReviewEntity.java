package com.example.yelp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
    @Id
    private String id; 

    private Map<String, Integer> votes; 
    private String userId; 
    private String reviewId; 
    private int stars; 
    private String date; 
    private String text; 
    private String type; 
    private String businessId;
}

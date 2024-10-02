package com.example.yelp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String id; // Corresponds to "_id" field in MongoDB

    private String yelpingSince; // Corresponds to "yelping_since"
    private Map<String, Integer> votes; // Corresponds to "votes" (funny, useful, cool)
    private int reviewCount; // Corresponds to "review_count"
    private String name; // Corresponds to "name"
    private String userId; // Corresponds to "user_id"
    private List<String> friends; // Corresponds to "friends"
    private int fans; // Corresponds to "fans"
    private double averageStars; // Corresponds to "average_stars"
    private String type; // Corresponds to "type"
    private Map<String, Integer> compliments; // Corresponds to "compliments"
    private List<String> elite; // Corresponds to "elite"
}

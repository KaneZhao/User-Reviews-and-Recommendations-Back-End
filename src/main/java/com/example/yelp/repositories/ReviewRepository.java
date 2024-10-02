package com.example.yelp.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.example.yelp.dto.UserReviewDTO;

@Repository
public class ReviewRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserReviewDTO> findReviewWithReviewDetails(String reviewId) {

        MatchOperation matchOperation = Aggregation.match(Criteria.where("review_id").is(reviewId));

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("users")
                .localField("user_id")
                .foreignField("_id")
                .as("reviewDetails");

        UnwindOperation unwindOperation = Aggregation.unwind("reviewDetails", true);

        ProjectionOperation projectOperation = Aggregation.project("votes", "stars", "date", "text", "type")
                .and("review_id").as("reviewId")
                .and("user_id").as("userId")
                .and("reviewDetails.name").as("userName");

        Aggregation aggregation = Aggregation.newAggregation(
                matchOperation,
                lookupOperation,
                unwindOperation,
                projectOperation);

        // Execute the aggregation query
        AggregationResults<UserReviewDTO> results = mongoTemplate.aggregate(aggregation, "reviews",
                UserReviewDTO.class);

        return results.getMappedResults();
    }
}

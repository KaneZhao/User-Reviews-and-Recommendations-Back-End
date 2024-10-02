package com.example.yelp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessEntity {
    @Id
    private String id;

    @Field("business_id")
    private String businessId;

    private String name;

    @Field("full_address")
    private String address;

    private String city;

    private String state;

    private double latitude;

    private double longitude;

    private double stars;

    @Field("review_count")
    private int reviewCount;

    private int isOpen;

    private Map<String, Object> attributes;

    private List<String> categories;

    private Map<String, String> hours;
}

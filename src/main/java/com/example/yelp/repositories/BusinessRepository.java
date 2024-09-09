package com.example.yelp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.yelp.model.BusinessEntity;
import java.util.Optional;

@Repository
public interface BusinessRepository extends MongoRepository<BusinessEntity, String>{
    Optional<BusinessEntity> findBusinessByBusinessId(String id);
} 
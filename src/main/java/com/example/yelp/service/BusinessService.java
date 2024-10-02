package com.example.yelp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yelp.model.BusinessEntity;
import com.example.yelp.repositories.BusinessRepository;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository repository;

    public Optional<BusinessEntity> findBusinessByBusinessId(String id) {
        return repository.findBusinessByBusinessId(id);
    }
}

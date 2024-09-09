package com.example.yelp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yelp.model.BusinessEntity;
import com.example.yelp.service.BusinessService;

@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {
    @Autowired
    private BusinessService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BusinessEntity>> getSingleBusiness(@PathVariable String id){
        return new ResponseEntity<Optional<BusinessEntity>>(service.findBusinessByBusinessId(id), HttpStatus.OK);
    }
}

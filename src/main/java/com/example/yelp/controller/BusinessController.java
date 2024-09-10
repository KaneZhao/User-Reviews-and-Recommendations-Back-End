package com.example.yelp.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yelp.model.BusinessEntity;
import com.example.yelp.service.BusinessService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {
    @Autowired
    private BusinessService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);
    
    @Operation(summary = "Get business by id")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Review created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input", 
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ErrorResponse.class))) 
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<BusinessEntity>> getSingleBusiness(@PathVariable String id){
        LOGGER.debug("createBrand success:{}", id);
        return new ResponseEntity<Optional<BusinessEntity>>(service.findBusinessByBusinessId(id), HttpStatus.OK);
    }
}

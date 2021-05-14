/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.java.subscribers.entities.User;
import com.java.subscribers.pojo.Message;
import com.java.subscribers.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Junior
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    UserService userService;
    
    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> save(@RequestBody User request) throws JsonProcessingException {
        
        logger.info("Post Request Payload: " + new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(request));

        //check if user already exists
        if (userService.checkIfUserExists(request)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Message("Username/Email  already exists","ERROR"));
        }
        
        var user = userService.saveUser(request);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new Message("User created successfully", "SUCCESS"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new Message("Error creating user", "ERROR"));
        }
    }
    
}

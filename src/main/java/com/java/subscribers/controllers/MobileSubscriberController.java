/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.java.subscribers.entities.Mobilesubscriber;
import com.java.subscribers.pojo.Message;
import com.java.subscribers.services.SubscriberService;
import com.java.subscribers.utils.Utils;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Junior
 */
@RestController
@RequestMapping("/mobile")
@Validated
public class MobileSubscriberController {

    private static final Logger logger = LoggerFactory.getLogger(MobileSubscriberController.class);

    @Autowired
    SubscriberService subscriberService;

    @GetMapping(value = "/subscribers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAllSubscribers() {
        var list = subscriberService.getAllSubscribers();

        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(list);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/subscribers/{search}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAllSubscribers(@PathVariable("search") String search) {
        var list = subscriberService.getAllSubscribers(search);

        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(list);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> save(@RequestBody @Valid Mobilesubscriber request) throws JsonProcessingException {
        
        logger.info("Post Request Payload: " + new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(request));

        //check if mobile number already exists
        if (subscriberService.findByMsisdn(request.getMsisdn()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Message("MSISDN already exists","ERROR"));
        }
        
        //check if mobile number is in the right format
        if (!Utils.checkMSISDN(request.getMsisdn())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Message("MSISDN not in right format eg. 35622123456", "ERROR"));
        }
        

        var mobilesubscriber = subscriberService.addSubscriber(request);
        if (mobilesubscriber != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(mobilesubscriber);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @PatchMapping(value = "/update/{msisdn}/{servicetype}")
    public ResponseEntity<?> edit(@PathVariable("msisdn") String msisdn, @PathVariable("servicetype") String servicetype) {
        var mobilesubscriber = subscriberService.updateSubscriber(msisdn, servicetype);
        if (mobilesubscriber != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new Message("Service Type Update Success","SUCCESS"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}

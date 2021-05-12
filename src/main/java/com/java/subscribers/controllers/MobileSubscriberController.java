/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.controllers;



import com.java.subscribers.entities.Mobilesubscriber;
import com.java.subscribers.services.SubscriberService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Junior
 */
@RestController
@RequestMapping("/mobile")
public class MobileSubscriberController { 
    
    private static final Logger logger = LoggerFactory.getLogger(MobileSubscriberController.class);
    
    @Autowired
    SubscriberService subscriberService;     
    
    @GetMapping(value = "/subscribers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAllSubscribers()
    {
        List<Mobilesubscriber> list = subscriberService.getAllSubscribers();
        return ResponseEntity.ok().body(list);
    }   
    
    @GetMapping(value = "/subscribers/{search}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAllSubscribers(@PathVariable("search") String search)
    {
        return ResponseEntity.ok().body(subscriberService.getAllSubscribers(search));
    } 
    
    
    @PostMapping(value = "/add",  consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})    
    public ResponseEntity<?> save(@RequestBody Mobilesubscriber request)
    {
        logger.info("Post Request Payload: "+ request.toString());
        
        Mobilesubscriber mobilesubscriber = subscriberService.addSubscriber(request);
        if(mobilesubscriber != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(mobilesubscriber);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
    
    @PutMapping(value = "/update/{msisdn}/{servicetype}")
    public ResponseEntity<?> edit(@PathVariable("msisdn") String msisdn, @PathVariable("servicetype") String servicetype)
    {
        System.out.println("inside put method");
        Optional<Mobilesubscriber> mobilesubscriber = subscriberService.updateSubscriber(msisdn, servicetype);
        if(mobilesubscriber.isPresent())
        {
            return ResponseEntity.status(HttpStatus.OK).body(mobilesubscriber);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }    
}

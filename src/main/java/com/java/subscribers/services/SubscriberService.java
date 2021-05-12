/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.services;

import com.java.subscribers.entities.Mobilesubscriber;
import com.java.subscribers.repository.SubscriberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Junior
 */
@Service
public class SubscriberService {

    @Autowired
    SubscriberRepository subrepo;

    //method to return all mobile subscribers from the database
    public List<Mobilesubscriber> getAllSubscribers() {
        return subrepo.findAll();
    }

    //method to return all mobile numbers matching a certain criteria
    public List<Mobilesubscriber> getAllSubscribers(String search) {
        return subrepo.findAllByMsisdnAndServiceType(search, search);
    }

    //method to add a subscriber
    public Mobilesubscriber addSubscriber(Mobilesubscriber subscriber) {
        return subrepo.save(subscriber);
    }

    public Optional<Mobilesubscriber> updateSubscriber(String msisdn, String servicetype) {
        if (subrepo.findByMsisdn(msisdn) != null) {
            Integer id =  subrepo.updateServiceType(servicetype, msisdn);
            return subrepo.findById(id);
        } 
        else 
        {
            return null;
        }
    }
}

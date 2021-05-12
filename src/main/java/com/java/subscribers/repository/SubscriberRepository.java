/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.repository;


import com.java.subscribers.entities.Mobilesubscriber;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Junior
 */
@Repository
public interface SubscriberRepository extends JpaRepository<Mobilesubscriber, Integer>{

    //query all subscribers by msisdn or service type
    @Query("SELECT m FROM Mobilesubscriber m WHERE msisdn = ?1 OR serviceType = ?2")
    List<Mobilesubscriber> findAllByMsisdnAndServiceType(String msisdn, String serviceType);
    
    //update service type of subscriber
    @Modifying
    @Transactional
    @Query("UPDATE Mobilesubscriber m set m.serviceType = ?1 WHERE m.msisdn = ?2")
    Integer updateServiceType(String serviceType, String msisdn);    
    
    //find subscriber using msisdn
    Mobilesubscriber findByMsisdn(String msisdn); 
    
}

package com.java.subscribers.exception;

public class SubscriberNotFoundException extends RuntimeException {

    public SubscriberNotFoundException(Long id) {
        super("Subscriber id not found : " + id);
    }

}
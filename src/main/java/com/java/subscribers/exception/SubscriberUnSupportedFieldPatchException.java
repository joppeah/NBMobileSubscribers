package com.java.subscribers.exception;

import java.util.Set;

public class SubscriberUnSupportedFieldPatchException extends RuntimeException {

    public SubscriberUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allowed.");
    }

}

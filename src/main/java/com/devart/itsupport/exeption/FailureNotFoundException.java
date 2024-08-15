package com.devart.itsupport.exeption;

public class FailureNotFoundException extends RuntimeException {
    public FailureNotFoundException(String message) {
        super(message);
    }
}

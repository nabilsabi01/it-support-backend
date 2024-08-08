package com.devart.itsupport.exeption;

public class UserNotFoundExpropriation extends RuntimeException {
    public UserNotFoundExpropriation() {
        super("User not found");
    }
}

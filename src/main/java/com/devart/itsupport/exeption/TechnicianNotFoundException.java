package com.devart.itsupport.exeption;

public class TechnicianNotFoundException extends RuntimeException {
    public TechnicianNotFoundException() {
        super("Technician not found");
    }
}

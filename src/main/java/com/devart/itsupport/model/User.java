package com.devart.itsupport.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@DiscriminatorValue("USER")
@Data
public class User extends Person {
    @OneToMany(mappedBy = "user")
    private List<Equipment> equipments;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;
}

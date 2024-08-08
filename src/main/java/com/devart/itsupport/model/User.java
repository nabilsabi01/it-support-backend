package com.devart.itsupport.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@DiscriminatorValue("USER")
@Getter
@Setter
public class User extends Person {
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Equipment> equipments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}

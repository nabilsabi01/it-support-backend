package com.devart.itsupport.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@DiscriminatorValue("TECHNICIAN")
@Getter
@Setter
public class Technician extends Person {
    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}

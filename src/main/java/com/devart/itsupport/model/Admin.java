package com.devart.itsupport.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@DiscriminatorValue("ADMIN")
@Getter
@Setter
public class Admin extends Person {

}

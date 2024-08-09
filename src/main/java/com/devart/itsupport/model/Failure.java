package com.devart.itsupport.model;

import com.devart.itsupport.enums.FailureType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Table(name = "failures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private FailureType type;

    @OneToMany(mappedBy = "failure")
    private List<FailureHistory> failureHistories;

    @OneToMany(mappedBy = "failure")
    private List<Ticket> tickets;
}

package com.devart.itsupport.model;

import com.devart.itsupport.enums.EquipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Table(name = "equipments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<FailureHistory> failureHistories;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}

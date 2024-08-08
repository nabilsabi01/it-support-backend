package com.devart.itsupport.dto;

import com.devart.itsupport.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private Long id;
    private String description;
    private TicketStatus status;
    private UserDTO user;
    private EquipmentDTO equipment;
    private FailureDTO failure;
    private TechnicianDTO technician;
}
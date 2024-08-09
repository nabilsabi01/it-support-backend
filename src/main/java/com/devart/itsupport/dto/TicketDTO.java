package com.devart.itsupport.dto;

import com.devart.itsupport.enums.TicketStatus;
import lombok.Data;

@Data
public class TicketDTO {
    private Long id;
    private String description;
    private TicketStatus status;
    private Long userId;
    private Long equipmentId;
    private Long failureId;
    private Long technicianId;
}

package com.devart.itsupport.dto;

import com.devart.itsupport.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketStatusUpdateDTO {
    private TicketStatus status;
}
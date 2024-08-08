package com.devart.itsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TechnicianDTO extends UserDTO {
    private List<TicketDTO> tickets;
}
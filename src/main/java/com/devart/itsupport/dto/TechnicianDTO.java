package com.devart.itsupport.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class TechnicianDTO extends PersonDTO {
    private List<TicketDTO> tickets;
}

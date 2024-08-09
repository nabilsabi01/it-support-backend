package com.devart.itsupport.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends PersonDTO {
    private List<EquipmentDTO> equipments;
    private List<TicketDTO> tickets;
}

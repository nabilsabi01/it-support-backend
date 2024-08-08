package com.devart.itsupport.dto;

import com.devart.itsupport.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends EquipmentDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private List<EquipmentDTO> equipments;
    private List<TicketDTO> tickets;
}
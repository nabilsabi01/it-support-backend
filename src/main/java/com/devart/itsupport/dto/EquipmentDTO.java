package com.devart.itsupport.dto;

import com.devart.itsupport.enums.EquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    private Long id;
    private String name;
    private EquipmentStatus status;
    private UserDTO user;
    private List<FailureHistoryDTO> failureHistories;
    private List<TicketDTO> tickets;
}
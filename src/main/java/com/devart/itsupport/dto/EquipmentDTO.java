package com.devart.itsupport.dto;

import com.devart.itsupport.enums.EquipmentStatus;
import lombok.Data;

@Data
public class EquipmentDTO {
    private Long id;
    private String name;
    private Long userId;
    private EquipmentStatus status;
}

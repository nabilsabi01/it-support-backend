package com.devart.itsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailureHistoryDTO {
    private Long id;
    private EquipmentDTO equipment;
    private FailureDTO failure;
    private LocalDateTime occurredAt;
}
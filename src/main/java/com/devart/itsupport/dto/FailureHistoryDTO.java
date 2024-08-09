package com.devart.itsupport.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FailureHistoryDTO {
    private Long id;
    private Long equipmentId;
    private Long failureId;
    private LocalDateTime occurredAt;
}

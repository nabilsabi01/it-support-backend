package com.devart.itsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailureDTO {
    private Long id;
    private String description;
    private List<FailureHistoryDTO> failureHistories;
    private List<TicketDTO> tickets;
}
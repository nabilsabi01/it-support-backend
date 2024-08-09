package com.devart.itsupport.dto;

import com.devart.itsupport.enums.FailureType;
import lombok.Data;

@Data
public class FailureDTO {
    private Long id;
    private String description;
    private FailureType type;
}
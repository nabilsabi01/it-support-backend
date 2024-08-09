package com.devart.itsupport.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponseDTO {
    private String token;
    private String role;
}
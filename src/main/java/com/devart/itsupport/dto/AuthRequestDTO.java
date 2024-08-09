package com.devart.itsupport.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthRequestDTO {
    private String email;
    private String password;
}
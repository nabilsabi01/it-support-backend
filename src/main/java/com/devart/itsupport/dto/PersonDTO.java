package com.devart.itsupport.dto;

import com.devart.itsupport.enums.Role;
import lombok.Data;

@Data
public class PersonDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
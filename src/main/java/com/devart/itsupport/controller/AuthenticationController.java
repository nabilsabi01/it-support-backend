package com.devart.itsupport.controller;

import com.devart.itsupport.dto.AuthRequestDTO;
import com.devart.itsupport.dto.AuthResponseDTO;
import com.devart.itsupport.dto.PersonDTO;
import com.devart.itsupport.exeption.EmailAlreadyExistsException;
import com.devart.itsupport.exeption.InvalidCredentialsException;
import com.devart.itsupport.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody PersonDTO request) {
        try {
            AuthResponseDTO response = authenticationService.register(request);
            return ResponseEntity.ok(response);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO request) {
        try {
            AuthResponseDTO response = authenticationService.authenticate(request);
            return ResponseEntity.ok(response);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
package com.devart.itsupport.service;

import com.devart.itsupport.dto.AuthRequestDTO;
import com.devart.itsupport.dto.AuthResponseDTO;
import com.devart.itsupport.dto.PersonDTO;
import com.devart.itsupport.model.Admin;
import com.devart.itsupport.model.Person;
import com.devart.itsupport.model.Technician;
import com.devart.itsupport.model.User;
import com.devart.itsupport.repository.PersonRepository;
import com.devart.itsupport.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO register(PersonDTO request) {
        Person user = createUserByRole(request);
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    private Person createUserByRole(PersonDTO request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Person person = switch (request.getRole()) {
            case ADMIN -> new Admin();
            case TECHNICIAN -> new Technician();
            default -> new User();
        };

        person.setName(request.getName());
        person.setEmail(request.getEmail());
        person.setPassword(encodedPassword);
        person.setRole(request.getRole());

        return person;
    }

    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}

package com.devart.itsupport.service;

import com.devart.itsupport.dto.AdminDTO;
import com.devart.itsupport.dto.PersonDTO;
import com.devart.itsupport.dto.TechnicianDTO;
import com.devart.itsupport.dto.UserDTO;
import com.devart.itsupport.mapper.AdminMapper;
import com.devart.itsupport.mapper.TechnicianMapper;
import com.devart.itsupport.mapper.UserMapper;
import com.devart.itsupport.model.Admin;
import com.devart.itsupport.model.Person;
import com.devart.itsupport.model.Technician;
import com.devart.itsupport.model.User;
import com.devart.itsupport.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final PersonRepository personRepository;
    private final AdminMapper adminMapper;
    private final TechnicianMapper technicianMapper;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public List<PersonDTO> getAllAccounts() {
        return personRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO createAccount(PersonDTO personDTO) {
        Person person = mapToEntity(personDTO);
        person.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        Person savedPerson = personRepository.save(person);
        return mapToDTO(savedPerson);
    }

    public PersonDTO updateAccount(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        updatePersonFromDTO(person, personDTO);
        Person updatedPerson = personRepository.save(person);
        return mapToDTO(updatedPerson);
    }

    public void deleteAccount(Long id) {
        personRepository.deleteById(id);
    }

    private PersonDTO mapToDTO(Person person) {
        return switch (person.getRole()) {
            case ADMIN -> adminMapper.toDTO((Admin) person);
            case TECHNICIAN -> technicianMapper.toDTO((Technician) person);
            case USER -> userMapper.toDTO((User) person);
        };
    }

    private Person mapToEntity(PersonDTO personDTO) {
        return switch (personDTO.getRole()) {
            case ADMIN -> adminMapper.toEntity((AdminDTO) personDTO);
            case TECHNICIAN -> technicianMapper.toEntity((TechnicianDTO) personDTO);
            case USER -> userMapper.toEntity((UserDTO) personDTO);
        };
    }

    private void updatePersonFromDTO(Person person, PersonDTO personDTO) {
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        if (personDTO.getPassword() != null && !personDTO.getPassword().isEmpty()) {
            person.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        }
        person.setRole(personDTO.getRole());
    }
}
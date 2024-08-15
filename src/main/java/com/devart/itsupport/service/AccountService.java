package com.devart.itsupport.service;

import com.devart.itsupport.dto.PersonDTO;
import com.devart.itsupport.exeption.ResourceNotFoundException;
import com.devart.itsupport.mapper.PersonMapper;
import com.devart.itsupport.model.Admin;
import com.devart.itsupport.model.Person;
import com.devart.itsupport.model.Technician;
import com.devart.itsupport.model.User;
import com.devart.itsupport.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final PasswordEncoder passwordEncoder;

    public List<PersonDTO> getAllAccounts() {
        List<Person> persons = personRepository.findAll();
        List<PersonDTO> personDTOs = new ArrayList<>();
        for (Person person : persons) {
            personDTOs.add(personMapper.toDTO(person));
        }
        return personDTOs;
    }

    public PersonDTO createAccount(PersonDTO personDTO) {
        Person person = mapToEntity(personDTO);
        person.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        Person savedPerson = personRepository.save(person);
        return personMapper.toDTO(savedPerson);
    }

    public PersonDTO updateAccount(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
        updatePersonFromDTO(person, personDTO);
        Person updatedPerson = personRepository.save(person);
        return personMapper.toDTO(updatedPerson);
    }

    public void deleteAccount(Long id) {
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Account not found with id: " + id);
        }
        personRepository.deleteById(id);
    }

    private Person mapToEntity(PersonDTO personDTO) {
        Person person = switch (personDTO.getRole()) {
            case ADMIN -> new Admin();
            case TECHNICIAN -> new Technician();
            case USER -> new User();
        };
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        person.setRole(personDTO.getRole());
        return person;
    }

    private void updatePersonFromDTO(Person person, PersonDTO personDTO) {
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        if (personDTO.getPassword() != null && !personDTO.getPassword().isEmpty()) {
            person.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        }
    }
}
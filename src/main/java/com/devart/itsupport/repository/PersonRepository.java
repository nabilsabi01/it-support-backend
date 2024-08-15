package com.devart.itsupport.repository;

import com.devart.itsupport.enums.Role;
import com.devart.itsupport.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByEmail(String email);
    List<Person> findByRole(Role role);
}
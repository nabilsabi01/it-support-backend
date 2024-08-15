package com.devart.itsupport.repository;

import com.devart.itsupport.model.Failure;
import com.devart.itsupport.enums.FailureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FailureRepository extends JpaRepository<Failure, Long> {
    List<Failure> findByType(FailureType type);
}
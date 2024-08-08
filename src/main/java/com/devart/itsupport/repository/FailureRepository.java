package com.devart.itsupport.repository;

import com.devart.itsupport.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailureRepository extends JpaRepository<Failure, Long> {

}

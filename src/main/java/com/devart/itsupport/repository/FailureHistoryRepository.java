package com.devart.itsupport.repository;

import com.devart.itsupport.model.FailureHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailureHistoryRepository extends JpaRepository<FailureHistory, Long> {

}

package com.devart.itsupport.repository;

import com.devart.itsupport.model.FailureHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FailureHistoryRepository extends JpaRepository<FailureHistory, Long> {
    List<FailureHistory> findByEquipmentId(Long equipmentId);
}
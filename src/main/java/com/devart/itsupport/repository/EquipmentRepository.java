package com.devart.itsupport.repository;

import com.devart.itsupport.enums.EquipmentStatus;
import com.devart.itsupport.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByUserId(Long userId);
    List<Equipment> findByStatus(EquipmentStatus status);
    List<Equipment> findByUserRole(String role);
}
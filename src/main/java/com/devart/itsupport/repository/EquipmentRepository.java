package com.devart.itsupport.repository;

import com.devart.itsupport.model.Equipment;
import com.devart.itsupport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findAllByUser(User user);
}
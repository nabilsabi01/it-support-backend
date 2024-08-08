package com.devart.itsupport.service;


import com.devart.itsupport.dto.EquipmentDTO;
import com.devart.itsupport.dto.UserDTO;
import com.devart.itsupport.exeption.EquipmentNotFoundException;
import com.devart.itsupport.mapper.EquipmentMapper;
import com.devart.itsupport.model.Equipment;
import com.devart.itsupport.model.User;
import com.devart.itsupport.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentMapper equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }

    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentMapper.toEntity(equipmentDTO);
        Equipment savedEquipment = equipmentRepository.save(equipment);
        return equipmentMapper.toDTO(savedEquipment);
    }

    public EquipmentDTO updateEquipment(Long id, EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found with id: " + id));
        equipment.setName(equipmentDTO.getName());
        equipment.setStatus(equipmentDTO.getStatus());
        equipment.setUser(equipmentMapper.toEntity(equipmentDTO.getUser()).getUser());
        Equipment updatedEquipment = equipmentRepository.save(equipment);
        return equipmentMapper.toDTO(updatedEquipment);
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    public List<EquipmentDTO> getAllEquipments() {
        List<Equipment> equipments = equipmentRepository.findAll();
        return equipments.stream()
                .map(equipmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EquipmentDTO> getEquipmentsByUser(UserDTO userDTO) {
        User user = equipmentMapper.toEntity(userDTO).getUser();
        List<Equipment> equipments = equipmentRepository.findAllByUser(user);
        return equipments.stream()
                .map(equipmentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
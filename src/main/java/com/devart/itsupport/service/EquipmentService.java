package com.devart.itsupport.service;

import com.devart.itsupport.dto.EquipmentDTO;
import com.devart.itsupport.enums.EquipmentStatus;
import com.devart.itsupport.exeption.ResourceNotFoundException;
import com.devart.itsupport.mapper.EquipmentMapper;
import com.devart.itsupport.model.Equipment;
import com.devart.itsupport.model.User;
import com.devart.itsupport.repository.EquipmentRepository;
import com.devart.itsupport.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final UserRepository userRepository;
    private final EquipmentMapper equipmentMapper;

    public EquipmentService(EquipmentRepository equipmentRepository, UserRepository userRepository, EquipmentMapper equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.userRepository = userRepository;
        this.equipmentMapper = equipmentMapper;
    }

    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentMapper.toEntity(equipmentDTO);
        if (equipmentDTO.getUserId() != null) {
            User user = userRepository.findById(equipmentDTO.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + equipmentDTO.getUserId()));
            equipment.setUser(user);
        }
        Equipment savedEquipment = equipmentRepository.save(equipment);
        return equipmentMapper.toDTO(savedEquipment);
    }

    public EquipmentDTO getEquipment(Long id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found with id: " + id));
        return equipmentMapper.toDTO(equipment);
    }

    public List<EquipmentDTO> getAllEquipment() {
        List<Equipment> equipments = equipmentRepository.findAll();
        List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
        for (Equipment equipment : equipments) {
            equipmentDTOs.add(equipmentMapper.toDTO(equipment));
        }
        return equipmentDTOs;
    }

    public List<EquipmentDTO> getEquipmentByUserId(Long userId) {
        List<Equipment> equipments = equipmentRepository.findByUserId(userId);
        List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
        for (Equipment equipment : equipments) {
            equipmentDTOs.add(equipmentMapper.toDTO(equipment));
        }
        return equipmentDTOs;
    }

    public List<EquipmentDTO> getEquipmentByStatus(EquipmentStatus status) {
        List<Equipment> equipments = equipmentRepository.findByStatus(status);
        List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
        for (Equipment equipment : equipments) {
            equipmentDTOs.add(equipmentMapper.toDTO(equipment));
        }
        return equipmentDTOs;
    }

//    public List<EquipmentDTO> getEquipmentByUserRole(String role) {
//        List<Equipment> equipments = equipmentRepository.findByUserRole(role);
//        List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
//        for (Equipment equipment : equipments) {
//            equipmentDTOs.add(equipmentMapper.toDTO(equipment));
//        }
//        return equipmentDTOs;
//    }

    public EquipmentDTO updateEquipment(Long id, EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found with id: " + id));
        equipment.setName(equipmentDTO.getName());
        equipment.setStatus(equipmentDTO.getStatus());
        if (equipmentDTO.getUserId() != null) {
            User user = userRepository.findById(equipmentDTO.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + equipmentDTO.getUserId()));
            equipment.setUser(user);
        }
        Equipment updatedEquipment = equipmentRepository.save(equipment);
        return equipmentMapper.toDTO(updatedEquipment);
    }

    public void deleteEquipment(Long id) {
        if (!equipmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipment not found with id: " + id);
        }
        equipmentRepository.deleteById(id);
    }
}

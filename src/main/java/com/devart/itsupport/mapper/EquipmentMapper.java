package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.EquipmentDTO;
import com.devart.itsupport.model.Equipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, FailureHistoryMapper.class, TicketMapper.class})
public interface EquipmentMapper {
    EquipmentDTO toDTO(Equipment equipment);
    Equipment toEntity(EquipmentDTO equipmentDTO);
}
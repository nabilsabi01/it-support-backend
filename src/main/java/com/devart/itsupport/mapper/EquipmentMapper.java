package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.EquipmentDTO;
import com.devart.itsupport.model.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    @Mapping(target = "userId", source = "user.id")
    EquipmentDTO toDTO(Equipment equipment);

    @Mapping(target = "user.id", source = "userId")
    Equipment toEntity(EquipmentDTO dto);
}

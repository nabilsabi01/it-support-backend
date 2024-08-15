package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.EquipmentDTO;
import com.devart.itsupport.model.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface EquipmentMapper {
    @Mapping(target = "userId", source = "user.id")
    EquipmentDTO toDTO(Equipment equipment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "failureHistories", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    Equipment toEntity(EquipmentDTO dto);

}
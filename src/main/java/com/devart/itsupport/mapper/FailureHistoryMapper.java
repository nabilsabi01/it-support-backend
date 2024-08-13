package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.FailureHistoryDTO;
import com.devart.itsupport.model.FailureHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EquipmentMapper.class, FailureMapper.class})
public interface FailureHistoryMapper {
    @Mapping(target = "equipmentId", source = "equipment.id")
    @Mapping(target = "failureId", source = "failure.id")
    FailureHistoryDTO toDTO(FailureHistory failureHistory);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "equipment", ignore = true)
    @Mapping(target = "failure", ignore = true)
    FailureHistory toEntity(FailureHistoryDTO dto);
}
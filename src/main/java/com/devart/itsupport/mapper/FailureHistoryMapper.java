package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.FailureHistoryDTO;
import com.devart.itsupport.model.FailureHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FailureHistoryMapper {
    @Mapping(target = "equipmentId", source = "equipment.id")
    @Mapping(target = "failureId", source = "failure.id")
    FailureHistoryDTO toDTO(FailureHistory failureHistory);

    @Mapping(target = "equipment.id", source = "equipmentId")
    @Mapping(target = "failure.id", source = "failureId")
    FailureHistory toEntity(FailureHistoryDTO dto);
}

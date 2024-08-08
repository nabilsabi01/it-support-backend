package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.FailureHistoryDTO;
import com.devart.itsupport.model.FailureHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EquipmentMapper.class, FailureMapper.class})
public interface FailureHistoryMapper {
    FailureHistoryDTO toDTO(FailureHistory failureHistory);
    FailureHistory toEntity(FailureHistoryDTO failureHistoryDTO);
}
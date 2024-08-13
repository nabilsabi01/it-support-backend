package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.FailureDTO;
import com.devart.itsupport.model.Failure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FailureMapper {
    FailureDTO toDTO(Failure failure);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "failureHistories", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    Failure toEntity(FailureDTO dto);
}
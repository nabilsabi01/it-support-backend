package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.FailureDTO;
import com.devart.itsupport.model.Failure;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FailureMapper {
    FailureDTO toDTO(Failure failure);
    Failure toEntity(FailureDTO dto);
}

package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.TechnicianDTO;
import com.devart.itsupport.model.Technician;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, TicketMapper.class})
public interface TechnicianMapper {
    @Mapping(target = "tickets", ignore = true)
    TechnicianDTO toDTO(Technician technician);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    Technician toEntity(TechnicianDTO dto);
}
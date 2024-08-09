package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.TechnicianDTO;
import com.devart.itsupport.model.Technician;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TicketMapper.class})
public interface TechnicianMapper {
    TechnicianDTO toDTO(Technician technician);
    Technician toEntity(TechnicianDTO dto);
}

package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.TicketDTO;
import com.devart.itsupport.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "equipmentId", source = "equipment.id")
    @Mapping(target = "failureId", source = "failure.id")
    @Mapping(target = "technicianId", source = "technician.id")
    TicketDTO toDTO(Ticket ticket);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "equipment.id", source = "equipmentId")
    @Mapping(target = "failure.id", source = "failureId")
    @Mapping(target = "technician.id", source = "technicianId")
    Ticket toEntity(TicketDTO dto);
}

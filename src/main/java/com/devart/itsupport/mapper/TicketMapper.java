package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.TicketDTO;
import com.devart.itsupport.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, EquipmentMapper.class, TechnicianMapper.class})
public interface TicketMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "equipmentId", source = "equipment.id")
    @Mapping(target = "failureId", source = "failure.id")
    @Mapping(target = "technicianId", source = "technician.id")
    TicketDTO toDTO(Ticket ticket);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "equipment", ignore = true)
    @Mapping(target = "failure", ignore = true)
    @Mapping(target = "technician", ignore = true)
    Ticket toEntity(TicketDTO dto);
}
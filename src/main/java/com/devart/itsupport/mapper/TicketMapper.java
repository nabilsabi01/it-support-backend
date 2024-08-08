package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.TechnicianDTO;
import com.devart.itsupport.dto.TicketDTO;
import com.devart.itsupport.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, EquipmentMapper.class, FailureMapper.class, TechnicianMapper.class})
public interface TicketMapper {
    TicketDTO toDTO(Ticket ticket);
    Ticket toEntity(TechnicianDTO ticketDTO);
}
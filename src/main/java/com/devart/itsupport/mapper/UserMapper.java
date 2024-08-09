package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.UserDTO;
import com.devart.itsupport.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EquipmentMapper.class, TicketMapper.class})
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO dto);
}

package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.UserDTO;
import com.devart.itsupport.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, EquipmentMapper.class, TicketMapper.class})
public interface UserMapper {
    @Mapping(target = "equipments", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "equipments", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    User toEntity(UserDTO dto);
}
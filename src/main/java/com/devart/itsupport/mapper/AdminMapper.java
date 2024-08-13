package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.AdminDTO;
import com.devart.itsupport.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface AdminMapper {
    AdminDTO toDTO(Admin admin);

    @Mapping(target = "id", ignore = true)
    Admin toEntity(AdminDTO dto);
}
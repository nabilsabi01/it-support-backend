package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.AdminDTO;
import com.devart.itsupport.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDTO toDto(Admin admin);
    Admin toEntity(AdminDTO adminDTO);
}

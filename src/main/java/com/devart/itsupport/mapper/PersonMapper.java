package com.devart.itsupport.mapper;

import com.devart.itsupport.dto.PersonDTO;
import com.devart.itsupport.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(target = "password", ignore = true)
    PersonDTO toDTO(Person person);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateEntityFromDto(PersonDTO dto, @MappingTarget Person entity);
}
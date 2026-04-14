package com.example.schedule.mappers.impl;

import com.example.schedule.dto.SchoolClassDto;
import com.example.schedule.enitities.SchoolClass;
import com.example.schedule.mappers.MapperInterface;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolClassMapper extends MapperInterface<SchoolClass, SchoolClassDto> {

    @Mapping(source = "groupIdentifier", target = "groupIdentifier")
    SchoolClass mapToEntity(SchoolClassDto dto);
    @Mapping(source = "groupIdentifier", target = "groupIdentifier")
    SchoolClassDto mapFromEntity(SchoolClass entity);

}

package com.example.schedule.mappers.impl;

import com.example.schedule.dto.TeacherDto;
import com.example.schedule.enitities.Teacher;
import com.example.schedule.mappers.MapperInterface;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends MapperInterface<Teacher, TeacherDto> {
}

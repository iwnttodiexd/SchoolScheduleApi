package com.example.schedule.mappers.impl;

import com.example.schedule.dto.LessonDto;
import com.example.schedule.enitities.Lesson;
import com.example.schedule.mappers.MapperInterface;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper extends MapperInterface<Lesson, LessonDto> {

}

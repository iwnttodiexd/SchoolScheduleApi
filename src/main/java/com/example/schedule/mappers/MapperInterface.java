package com.example.schedule.mappers;

public interface MapperInterface <T, R>{

    T mapToEntity(R dto);
    R mapFromEntity(T entity);
}

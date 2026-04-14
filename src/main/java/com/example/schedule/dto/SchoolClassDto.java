package com.example.schedule.dto;

import com.example.schedule.enitities.ClassGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record SchoolClassDto(
        @NotNull @Valid ClassGroup groupIdentifier
        ) {
}

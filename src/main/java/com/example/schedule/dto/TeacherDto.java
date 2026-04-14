package com.example.schedule.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TeacherDto(
        @Valid @NotNull String name,
        @Valid @NotNull String surname
) {
}

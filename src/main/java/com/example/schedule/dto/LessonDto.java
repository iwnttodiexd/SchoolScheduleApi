package com.example.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record LessonDto(
        @Valid @NotNull String subject,
        @Valid @NotNull DayOfWeek dayOfWeek,
        @Valid @NotNull
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "HH:mm") LocalTime startTime,
        @Valid @NotNull
        @JsonFormat(
                shape = JsonFormat.Shape.STRING, pattern = "HH:mm"
        ) LocalTime endTime,
        @Valid @NotNull Integer schoolRoomNumber
        ) {
}

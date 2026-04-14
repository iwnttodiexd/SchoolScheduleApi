package com.example.schedule.controllers;

import com.example.schedule.mappers.impl.LessonMapper;
import com.example.schedule.mappers.impl.SchoolClassMapper;
import com.example.schedule.services.SchoolClassService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;
    private final SchoolClassMapper schoolClassMapper;
    private final LessonMapper lessonMapper;

    public SchoolClassController(SchoolClassService schoolClassService, SchoolClassMapper schoolClassMapper, LessonMapper lessonMapper) {
        this.schoolClassService = schoolClassService;
        this.schoolClassMapper = schoolClassMapper;
        this.lessonMapper = lessonMapper;
    }

    @GetMapping("/classes")
    public ResponseEntity<?> getClasses(
            @PageableDefault(size = 20, sort = "id") Pageable pageable
            ){

        return ResponseEntity.ok(
                schoolClassService.getClasses(pageable)
                        .map(schoolClassMapper::mapFromEntity)

        );
    }

    @GetMapping("/classes/{id}/schedule")
    public ResponseEntity<?> getClassSchedule(
            @PathVariable Long id,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            @PageableDefault(sort = "id") Pageable pageable
            ){

        return ResponseEntity.ok(
                schoolClassService.getClassSchedule(id, date, pageable)
                        .map(lessonMapper::mapFromEntity)
        );
    }

}

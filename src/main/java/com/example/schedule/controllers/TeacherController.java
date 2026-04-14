package com.example.schedule.controllers;

import com.example.schedule.mappers.impl.TeacherMapper;
import com.example.schedule.services.TeacherService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    public TeacherController(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }

    @GetMapping("/teachers")
    public ResponseEntity<?> getTeachers(
            @PageableDefault(
                    sort = "id",
                    size = 20,
                    direction = Sort.Direction.ASC) Pageable pageable
            ){
        return ResponseEntity.ok(
            teacherService.getTeachers(pageable)
                    .map(teacherMapper::mapFromEntity)
        );
    }
}

package com.example.schedule.services;

import com.example.schedule.enitities.Teacher;
import com.example.schedule.repositories.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Page<Teacher> getTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }
}

package com.example.schedule.services;

import com.example.schedule.enitities.Lesson;
import com.example.schedule.enitities.SchoolClass;
import com.example.schedule.repositories.LessonRepository;
import com.example.schedule.repositories.SchoolClassRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final LessonRepository lessonRepository;

    public SchoolClassService(SchoolClassRepository schoolClassRepository, LessonRepository lessonRepository) {
        this.schoolClassRepository = schoolClassRepository;
        this.lessonRepository = lessonRepository;
    }

    public Page<SchoolClass> getClasses(Pageable pageable) {
        return schoolClassRepository.findAll(pageable);
    }

    public Page<Lesson> getClassSchedule(Long id, LocalDate date, Pageable pageable) {
        if (!schoolClassRepository.existsById(id)) {
            throw new NoSuchElementException("School class not found with id: " + id);
        }
        return lessonRepository.findBySchoolClassIdAndDayOfTheWeek(id, date.getDayOfWeek(), pageable);
    }
}

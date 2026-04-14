package com.example.schedule.repositories;

import com.example.schedule.enitities.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Page<Lesson> findBySchoolClassIdAndDayOfTheWeek(
            Long id,
            DayOfWeek dayOfTheWeek,
            Pageable pageable
    );


}

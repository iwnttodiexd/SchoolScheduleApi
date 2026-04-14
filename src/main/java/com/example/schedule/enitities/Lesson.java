package com.example.schedule.enitities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfTheWeek;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;

    private Integer schoolRoomNumber;

    @ManyToOne
    @JoinColumn(name = "teachers_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

}

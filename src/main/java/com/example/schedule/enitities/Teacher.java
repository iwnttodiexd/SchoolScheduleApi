package com.example.schedule.enitities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "teacher")
    private List<Lesson> lessons;
}

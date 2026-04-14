package com.example.schedule.enitities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "school_classes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ClassGroup groupIdentifier;

    @OneToMany(mappedBy = "schoolClass")
    private List<Lesson> lessons;

}

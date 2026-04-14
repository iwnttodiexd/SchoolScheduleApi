package com.example.schedule.repositories;

import com.example.schedule.enitities.SchoolClass;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    Page<SchoolClass> findAll(@NonNull Pageable pageable);

}

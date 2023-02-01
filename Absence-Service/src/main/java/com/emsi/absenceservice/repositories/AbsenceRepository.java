package com.emsi.absenceservice.repositories;

import com.emsi.absenceservice.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface AbsenceRepository extends JpaRepository<Absence, String> {
    @Query("select a from Absence a where a.studentId = ?1")
    Collection<Absence> getStudentAbsence(String studentId);
    @Query("select a from Absence a where a.courseId = ?1")
    Collection<Absence> getCourseAbsence(String courseId);
}

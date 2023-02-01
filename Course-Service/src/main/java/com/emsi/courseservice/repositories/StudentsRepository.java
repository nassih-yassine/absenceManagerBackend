package com.emsi.courseservice.repositories;

import com.emsi.courseservice.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentsRepository extends JpaRepository<Students, String> {
    @Query("select s from Students s where s.studentId = ?1 and s.course.courseId = ?2")
    Students getStudentFromCourse(String studentId, String courseId);
}

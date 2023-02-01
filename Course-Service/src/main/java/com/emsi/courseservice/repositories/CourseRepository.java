package com.emsi.courseservice.repositories;

import com.emsi.courseservice.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, String> {
    @Query("select c from Course c where lower(c.name) = lower(?1) ")
    Course findCoursesByName(String name);
}

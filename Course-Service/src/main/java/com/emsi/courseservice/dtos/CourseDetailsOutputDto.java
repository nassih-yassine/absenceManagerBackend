package com.emsi.courseservice.dtos;

import com.emsi.courseservice.entities.Students;
import com.emsi.courseservice.models.Professor;
import lombok.Data;

import java.util.Collection;

@Data
public class CourseDetailsOutputDto {
    private String courseId;
    private String name;
    private String description;
    private Professor professor;
    private Collection<Students> students;
}

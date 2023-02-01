package com.emsi.absenceservice.dtos;

import com.emsi.absenceservice.models.Course;
import com.emsi.absenceservice.models.Student;
import lombok.Data;

@Data
public class AbsenceOutputDto {
    private String id;
    private Student student;
    private Course course;
}

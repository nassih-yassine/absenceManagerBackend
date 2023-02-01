package com.emsi.absenceservice.entities;

import com.emsi.absenceservice.models.Course;
import com.emsi.absenceservice.models.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Absence {
    @Id
    private String id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String studentId;
    @Transient
    private Student student;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String courseId;
    @Transient
    private Course course;
}

package com.emsi.courseservice.entities;

import com.emsi.courseservice.models.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Students {
    @Id @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String studentId;
    @Transient
    private Student student;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Course course;
}

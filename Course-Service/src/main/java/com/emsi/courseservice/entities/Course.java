package com.emsi.courseservice.entities;

import com.emsi.courseservice.models.Professor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Course {
    @Id
    private String courseId;
    private String name;
    private String description;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String professorId;
    @Transient
    private Professor professor;
    @OneToMany(mappedBy = "course")
    private Collection<Students> students;

}

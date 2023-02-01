package com.emsi.absencedatageneratorservice.models;

import lombok.Data;

import java.util.Collection;

@Data
public class CourseDetails {
    private String courseId;
    private String name;
    private String description;
    private Collection<Students> students;
}

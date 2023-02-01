package com.emsi.absenceservice.exceptions;

public class CourseIdNotFoundException extends Exception {
    public CourseIdNotFoundException(String courseId) {
        super("Course with id: " + courseId + ", Not Found!!!!");
    }
}

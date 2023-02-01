package com.emsi.courseservice.exceptions;

public class CourseNameExistException extends Exception {
    public CourseNameExistException(String name) {
        super("Course with name: " + name.toUpperCase() + ", Already Exist!!!!!!");
    }
}

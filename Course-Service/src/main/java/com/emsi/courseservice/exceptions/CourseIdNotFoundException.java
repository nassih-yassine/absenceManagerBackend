package com.emsi.courseservice.exceptions;

public class CourseIdNotFoundException extends Exception{
    public CourseIdNotFoundException(String id) {
        super("Course with Id: "+ id + ", Not Found!!!!");
    }
}

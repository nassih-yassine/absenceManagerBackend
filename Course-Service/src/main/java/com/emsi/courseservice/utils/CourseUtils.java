package com.emsi.courseservice.utils;

import com.emsi.courseservice.dtos.CourseInputDto;
import com.emsi.courseservice.entities.Course;

import java.util.Optional;
import java.util.UUID;

public class CourseUtils {
    public static boolean checkCourseInputDtoFields(CourseInputDto courseInputDto){
        return courseInputDto.getName() == null || courseInputDto.getName().isEmpty()
                || courseInputDto.getDescription() == null || courseInputDto.getDescription().isEmpty();
    }

    public static Course setCourseAttribute(CourseInputDto courseInputDto, String id){
        Course course = new Course();
        Optional<String> studentId = Optional.ofNullable(id);
        if(studentId.isPresent()){
            course.setCourseId(id);
        }
        else{
            course.setCourseId(UUID.randomUUID().toString());
        }
        course.setName(courseInputDto.getName());
        course.setDescription(courseInputDto.getDescription());
        return course;
    }
}

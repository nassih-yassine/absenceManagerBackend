package com.emsi.courseservice.services;

import com.emsi.courseservice.dtos.CourseDetailsOutputDto;
import com.emsi.courseservice.dtos.CourseInputDto;
import com.emsi.courseservice.dtos.CourseSimpleOutputDto;

import java.util.Collection;

public interface CourseService {
    CourseSimpleOutputDto createCourse(CourseInputDto courseInputDto) throws Exception;
    CourseSimpleOutputDto updateCourse(String id, CourseInputDto courseInputDto) throws Exception;
    void deleteCourse(String id) throws Exception;
    CourseSimpleOutputDto getSimpleSingle(String courseId) throws Exception;
    CourseDetailsOutputDto getDetailsSingle(String courseId) throws Exception;
    Collection<CourseSimpleOutputDto> getAll();

    Collection<CourseDetailsOutputDto> getAllDetails();

    CourseDetailsOutputDto updateCourseProfessor(String professorId, String courseId) throws Exception;
    CourseDetailsOutputDto addStudentToCourse(String studentId, String courseId) throws Exception;
    void removeStudentFromCourse(String studentId, String courseId) throws Exception;

}

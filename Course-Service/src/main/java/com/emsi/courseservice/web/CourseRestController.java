package com.emsi.courseservice.web;

import com.emsi.courseservice.dtos.CourseDetailsOutputDto;
import com.emsi.courseservice.dtos.CourseInputDto;
import com.emsi.courseservice.dtos.CourseSimpleOutputDto;
import com.emsi.courseservice.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class CourseRestController {
    private CourseService courseService;
    @PostMapping("/course")
    public CourseSimpleOutputDto createCourse(@RequestBody CourseInputDto courseInputDto) throws Exception {
        return courseService.createCourse(courseInputDto);
    }

    @PutMapping("/course/{id}")
    public CourseSimpleOutputDto updateCourse(@RequestBody CourseInputDto courseInputDto, @PathVariable String id) throws Exception {
        return courseService.updateCourse(id, courseInputDto);
    }

    @GetMapping("/course/{courseId}/new-professor/{professorId}")
    public CourseDetailsOutputDto updateCourseProfessor(@PathVariable String courseId, @PathVariable String professorId) throws Exception {
        return courseService.updateCourseProfessor(professorId, courseId);
    }

    @GetMapping("/course/{courseId}/new-student/{studentId}")
    public CourseDetailsOutputDto addStudentToCourse(@PathVariable String courseId, @PathVariable String studentId) throws Exception {
        return courseService.addStudentToCourse(studentId, courseId);
    }

    @GetMapping("/courses")
    public Collection<CourseSimpleOutputDto> courseList(){
        return courseService.getAll();
    }

    @GetMapping("/courses/details")
    public Collection<CourseDetailsOutputDto> courseDetailsList(){
        return courseService.getAllDetails();
    }

    @GetMapping("/course/simple/{id}")
    public CourseSimpleOutputDto getSimpleCourse(@PathVariable String id) throws Exception {
        return courseService.getSimpleSingle(id);
    }

    @GetMapping("/course/detail/{id}")
    public CourseDetailsOutputDto getDetailCourse(@PathVariable String id) throws Exception {
        return courseService.getDetailsSingle(id);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable String id) throws Exception {
        courseService.deleteCourse(id);
    }

    @DeleteMapping("/course/{courseId}/remove-student/{studentId}")
    public void removeStudentFromCourse(@PathVariable String courseId, @PathVariable String studentId) throws Exception {
        courseService.removeStudentFromCourse(studentId, courseId);
    }
}

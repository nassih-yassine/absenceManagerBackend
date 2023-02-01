package com.emsi.courseservice.mappers;

import com.emsi.courseservice.dtos.CourseDetailsOutputDto;
import com.emsi.courseservice.dtos.CourseSimpleOutputDto;
import com.emsi.courseservice.entities.Course;
import com.emsi.courseservice.entities.Students;
import com.emsi.courseservice.models.Professor;
import com.emsi.courseservice.models.Student;
import com.emsi.courseservice.services.ProfessorRestClient;
import com.emsi.courseservice.services.StudentRestClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class MapperService {
    StudentRestClient studentRestClient;
    ProfessorRestClient professorRestClient;
    public CourseSimpleOutputDto fromCourseToSimpleInfo(Course course){
        CourseSimpleOutputDto courseSimpleOutputDto = new CourseSimpleOutputDto();
        BeanUtils.copyProperties(course, courseSimpleOutputDto);
        return courseSimpleOutputDto;
    }

    public CourseDetailsOutputDto fromCourseToDetailsInfo(Course course){
        CourseDetailsOutputDto courseDetailsOutputDto = new CourseDetailsOutputDto();
        BeanUtils.copyProperties(course, courseDetailsOutputDto);
        Professor professor = professorRestClient.getProfessor(course.getProfessorId());
        Collection<Students> students = course.getStudents().stream().map(
                student -> {
                    Student s = studentRestClient.getStudent(student.getStudentId());
                    Students finalStudent = new Students();
                    finalStudent.setStudentId(s.getStudentId());
                    finalStudent.setStudent(s);
                    return finalStudent;
                }
        ).toList();
        courseDetailsOutputDto.setProfessor(professor);
        courseDetailsOutputDto.setStudents(students);
        return courseDetailsOutputDto;
    }
}

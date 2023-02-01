package com.emsi.courseservice.services;

import com.emsi.courseservice.dtos.CourseDetailsOutputDto;
import com.emsi.courseservice.dtos.CourseInputDto;
import com.emsi.courseservice.dtos.CourseSimpleOutputDto;
import com.emsi.courseservice.entities.Course;
import com.emsi.courseservice.entities.Students;
import com.emsi.courseservice.exceptions.CourseIdNotFoundException;
import com.emsi.courseservice.exceptions.CourseNameExistException;
import com.emsi.courseservice.exceptions.MissingFieldsException;
import com.emsi.courseservice.mappers.MapperService;
import com.emsi.courseservice.models.Professor;
import com.emsi.courseservice.models.Student;
import com.emsi.courseservice.repositories.CourseRepository;
import com.emsi.courseservice.repositories.StudentsRepository;
import com.emsi.courseservice.utils.CourseUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private ProfessorRestClient professorRestClient;
    private StudentRestClient studentRestClient;
    private CourseRepository courseRepository;
    private StudentsRepository studentsRepository;
    private MapperService mapperService;

    @Override
    public CourseSimpleOutputDto createCourse(CourseInputDto courseInputDto) throws Exception {
        if(CourseUtils.checkCourseInputDtoFields(courseInputDto))
            throw new MissingFieldsException();

        if (courseRepository.findCoursesByName(courseInputDto.getName()) != null)
            throw new CourseNameExistException(courseInputDto.getName());

        Course course = CourseUtils.setCourseAttribute(courseInputDto, null);
        return mapperService.fromCourseToSimpleInfo(courseRepository.save(course));
    }
    @Override
    public CourseSimpleOutputDto updateCourse(String id, CourseInputDto courseInputDto) throws Exception {
        courseRepository.findById(id).orElseThrow(() -> new CourseIdNotFoundException(id));
        if(CourseUtils.checkCourseInputDtoFields(courseInputDto))
            throw new MissingFieldsException();

        if (courseRepository.findCoursesByName(courseInputDto.getName()) != null)
            throw new CourseNameExistException(courseInputDto.getName());

        Course course = CourseUtils.setCourseAttribute(courseInputDto, id);
        return mapperService.fromCourseToSimpleInfo(courseRepository.save(course));
    }
    @Override
    public void deleteCourse(String id) throws Exception {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseIdNotFoundException(id));
        courseRepository.delete(course);
    }
    @Override
    public CourseSimpleOutputDto getSimpleSingle(String courseId) throws Exception {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseIdNotFoundException(courseId));
        return mapperService.fromCourseToSimpleInfo(course);
    }
    @Override
    public CourseDetailsOutputDto getDetailsSingle(String courseId) throws Exception {
        return mapperService.fromCourseToDetailsInfo(courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseIdNotFoundException(courseId)));
    }
    @Override
    public Collection<CourseSimpleOutputDto> getAll() {
        return courseRepository.findAll().stream().map(mapperService::fromCourseToSimpleInfo).toList();
    }
    @Override
    public Collection<CourseDetailsOutputDto> getAllDetails(){
        return courseRepository.findAll().stream().map(mapperService::fromCourseToDetailsInfo).toList();
    }
    @Override
    public CourseDetailsOutputDto updateCourseProfessor(String professorId, String courseId) throws Exception {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseIdNotFoundException(courseId));

        Professor professor = professorRestClient.getProfessor(professorId);
        if(professor == null)
            throw new Exception("Professor id not found exception");

        course.setProfessorId(professorId);
        course.setProfessor(professor);
        return mapperService.fromCourseToDetailsInfo(courseRepository.save(course));
    }
    @Override
    public CourseDetailsOutputDto addStudentToCourse(String studentId, String courseId) throws Exception {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseIdNotFoundException(courseId));

        Student student = studentRestClient.getStudent(studentId);
        if(student == null)
            throw new Exception("Student id not found exception");

        Students students = new Students();
        students.setStudentId(student.getStudentId());
        students.setStudent(student);
        students.setCourse(course);
        studentsRepository.save(students);
        courseRepository.save(course);
        return mapperService.fromCourseToDetailsInfo(course);
    }
    @Override
    public void removeStudentFromCourse(String studentId, String courseId) throws Exception {
        Students student = studentsRepository.getStudentFromCourse(studentId, courseId);
        if(student == null)
            throw new Exception("Student not found");
        studentsRepository.delete(student);
    }
}

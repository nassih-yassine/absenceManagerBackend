package com.emsi.absenceservice.mappers;

import com.emsi.absenceservice.dtos.AbsenceOutputDto;
import com.emsi.absenceservice.entities.Absence;
import com.emsi.absenceservice.models.Course;
import com.emsi.absenceservice.models.Student;
import com.emsi.absenceservice.services.CourseRestClient;
import com.emsi.absenceservice.services.StudentRestClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MapperService {
    private StudentRestClient studentRestClient;
    private CourseRestClient courseRestClient;
    public AbsenceOutputDto fromAbsence(Absence absence){
        AbsenceOutputDto absenceOutputDto = new AbsenceOutputDto();
        BeanUtils.copyProperties(absence, absenceOutputDto);
        Student student = studentRestClient.getStudent(absence.getStudentId());
        Course course = courseRestClient.getCourse(absence.getCourseId());
        absenceOutputDto.setCourse(course);
        absenceOutputDto.setStudent(student);
        return absenceOutputDto;
    }
}

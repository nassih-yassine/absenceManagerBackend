package com.emsi.absenceservice.services;

import com.emsi.absenceservice.dtos.AbsenceInputDto;
import com.emsi.absenceservice.dtos.AbsenceOutputDto;

import java.util.Collection;

public interface AbsenceService {
    //Create
    AbsenceOutputDto addAbsence(AbsenceInputDto absenceInputDto) throws Exception;
    //Get All
    Collection<AbsenceOutputDto> getAll();
    //Get Single
    AbsenceOutputDto getSingle(String id) throws Exception;
    //Show Related to Single Student
    Collection<AbsenceOutputDto> getStudentAbsence(String studentId) throws Exception;
    //Show Related to Single Course
    Collection<AbsenceOutputDto> getCourseAbsence(String courseId) throws Exception;
    //Delete
    void deleteAbsence(String id) throws Exception;

}

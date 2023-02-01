package com.emsi.studentservice.service;

import com.emsi.studentservice.dtos.StudentInputDto;
import com.emsi.studentservice.dtos.StudentOutputDto;
import com.emsi.studentservice.exceptions.IncompleteInformations;
import com.emsi.studentservice.exceptions.StudentNICExistException;
import com.emsi.studentservice.exceptions.StudentNotFoundException;

import java.util.List;


public interface StudentService {
    StudentOutputDto addStudent(StudentInputDto studentInputDto) throws IncompleteInformations, StudentNICExistException;
    StudentOutputDto updateStudent(String studentId, StudentInputDto studentInputDto) throws StudentNotFoundException, IncompleteInformations;

    void deleteStudent(String studentId) throws StudentNotFoundException;
    List<StudentOutputDto> studentList();
    StudentOutputDto searchStudent(String id) throws StudentNotFoundException;
}

package com.emsi.studentservice.service;

import com.emsi.studentservice.dtos.StudentInputDto;
import com.emsi.studentservice.dtos.StudentOutputDto;
import com.emsi.studentservice.entities.Student;
import com.emsi.studentservice.exceptions.IncompleteInformations;
import com.emsi.studentservice.exceptions.StudentNICExistException;
import com.emsi.studentservice.exceptions.StudentNotFoundException;
import com.emsi.studentservice.mappers.StudentMapper;
import com.emsi.studentservice.repos.StudentRepo;
import com.emsi.studentservice.utils.KeycloakUtils;
import com.emsi.studentservice.utils.StudentUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;
    private StudentMapper studentMapper;

    @Override
    public StudentOutputDto addStudent(StudentInputDto studentInputDto) throws IncompleteInformations, StudentNICExistException {
        if (StudentUtils.checkStudentInputDtoFields(studentInputDto))
            throw new IncompleteInformations("Missing Fields!!!!!");

        Student studentCheckNIC = studentRepo.findStudentByNIC(studentInputDto.getNic());
        if(studentCheckNIC != null)
            throw new StudentNICExistException(studentInputDto.getNic());

        Student student = StudentUtils.setStudentAttribute(studentInputDto, null);

        KeycloakUtils.createKeycloakUserWithRole(student, "Admin123");
        return studentMapper.fromStudent(studentRepo.save(student));
    }

    @Override
    public StudentOutputDto updateStudent(String studentId, StudentInputDto studentInputDto) throws StudentNotFoundException, IncompleteInformations {
        if (StudentUtils.checkStudentInputDtoFields(studentInputDto))
            throw new IncompleteInformations("Missing Fields!!!!!");

        studentRepo.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not Found"));

        Student student = StudentUtils.setStudentAttribute(studentInputDto, studentId);
        return studentMapper.fromStudent(studentRepo.save(student));

    }

    @Override
    public void deleteStudent(String studentId) throws StudentNotFoundException {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not Found"));
        studentRepo.delete(student);
    }

    @Override
    public List<StudentOutputDto> studentList() {
        return studentRepo.findAll()
                .stream().map(studentMapper::fromStudent).toList();
    }

    @Override
    public StudentOutputDto searchStudent(String id) throws StudentNotFoundException {
        Student student = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not Found"));
        return studentMapper.fromStudent(student);

    }
}


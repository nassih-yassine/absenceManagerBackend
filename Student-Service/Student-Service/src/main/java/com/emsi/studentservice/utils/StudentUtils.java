package com.emsi.studentservice.utils;

import com.emsi.studentservice.dtos.StudentInputDto;
import com.emsi.studentservice.entities.Student;

import java.util.Optional;
import java.util.UUID;

public class StudentUtils {
    public static boolean checkStudentInputDtoFields(StudentInputDto studentInputDto){
        return studentInputDto.getFirstName() == null || studentInputDto.getFirstName().isEmpty()
                || studentInputDto.getLastName() == null || studentInputDto.getLastName().isEmpty()
                || studentInputDto.getBirthDate() == null || studentInputDto.getGender() == null
                || studentInputDto.getNic() == null || studentInputDto.getNic().isEmpty()
                || studentInputDto.getAddress() == null || studentInputDto.getAddress().isEmpty()
                || studentInputDto.getAccessYear() == null
                || studentInputDto.getEmail() == null || studentInputDto.getEmail().isEmpty()
                || studentInputDto.getPhoneNumber() == null || studentInputDto.getPhoneNumber().isEmpty();
    }

    public static Student setStudentAttribute(StudentInputDto studentInputDto, String id){
        Student student = new Student();
        Optional<String> studentId = Optional.ofNullable(id);
        if(studentId.isPresent()){
            student.setStudentId(id);
        }
        else{
            student.setStudentId(UUID.randomUUID().toString());
        }
        student.setFirstName(studentInputDto.getFirstName());
        student.setLastName(studentInputDto.getLastName());
        student.setBirthdate(studentInputDto.getBirthDate());
        student.setNic(studentInputDto.getNic());
        student.setGender(studentInputDto.getGender());
        student.setAddress(studentInputDto.getAddress());
        student.setAccessYear(studentInputDto.getAccessYear());
        student.setEmail(studentInputDto.getEmail());
        student.setPhoneNumber(studentInputDto.getPhoneNumber());
        return student;
    }
}

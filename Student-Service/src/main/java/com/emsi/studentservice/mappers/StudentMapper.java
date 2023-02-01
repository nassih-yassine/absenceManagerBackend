package com.emsi.studentservice.mappers;


import com.emsi.studentservice.dtos.StudentOutputDto;
import com.emsi.studentservice.entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentOutputDto fromStudent (Student student){
        StudentOutputDto studentOutputDto = new StudentOutputDto();
        BeanUtils.copyProperties(student,studentOutputDto);
        return studentOutputDto;
    }
}

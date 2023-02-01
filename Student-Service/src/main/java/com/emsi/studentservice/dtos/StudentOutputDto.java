package com.emsi.studentservice.dtos;

import com.emsi.studentservice.enums.Gender;
import lombok.Data;



@Data
public class StudentOutputDto {
    private String studentId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
}

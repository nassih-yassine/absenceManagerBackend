package com.emsi.courseservice.models;

import com.emsi.courseservice.enums.Gender;
import lombok.Data;

@Data
public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
}

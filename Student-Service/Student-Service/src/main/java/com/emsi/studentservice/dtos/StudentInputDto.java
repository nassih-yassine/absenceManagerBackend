package com.emsi.studentservice.dtos;

import com.emsi.studentservice.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class StudentInputDto {
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String nic;
    private Gender gender;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date accessYear;
    private String email;
    private String phoneNumber;
}
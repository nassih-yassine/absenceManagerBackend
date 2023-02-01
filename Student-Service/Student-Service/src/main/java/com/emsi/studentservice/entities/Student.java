package com.emsi.studentservice.entities;

import com.emsi.studentservice.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String nic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date accessYear;
    private String phoneNumber;
    private String email;
}
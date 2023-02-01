package com.emsi.professorservice.dtos;

import com.emsi.professorservice.enums.Sex;
import lombok.Data;

@Data
public class ProfessorInputDto {
    private String firstname;
    private String lastname;
    private String nic; //National Identity Card
    private Sex sex;
    private String address;
    private String email;
    private String phoneNumber;
}

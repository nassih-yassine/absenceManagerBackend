package com.emsi.professorservice.dtos;

import lombok.Data;

@Data
public class ProfessorOutputDto {
    private String professorId;
    private String firstname;
    private String lastname;
    private String email;
}

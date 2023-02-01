package com.emsi.professorservice.utils;

import com.emsi.professorservice.dtos.ProfessorInputDto;
import com.emsi.professorservice.entities.Professor;

import java.util.Optional;
import java.util.UUID;

public class ProfessorUtils {
    public static boolean checkProfessorInputDtoFields(ProfessorInputDto professorInputDto) {
        return professorInputDto.getAddress() == null || professorInputDto.getAddress().isEmpty()
                || professorInputDto.getFirstname() == null || professorInputDto.getFirstname().isEmpty()
                || professorInputDto.getLastname() == null || professorInputDto.getLastname().isEmpty()
                || professorInputDto.getNic() == null || professorInputDto.getNic().isEmpty()
                || professorInputDto.getSex() == null
                || professorInputDto.getPhoneNumber() == null || professorInputDto.getPhoneNumber().isEmpty()
                || professorInputDto.getEmail() == null || professorInputDto.getEmail().isEmpty();
    }

    public static Professor setProfessorAttribute(ProfessorInputDto professorInputDto, String id) {
        Professor professor = new Professor();
        Optional<String> professorId = Optional.ofNullable(id);
        if (professorId.isPresent()) {
            professor.setProfessorId(id);
        } else {
            professor.setProfessorId(UUID.randomUUID().toString());
        }

        professor.setFirstname(professorInputDto.getFirstname());
        professor.setLastname(professorInputDto.getLastname());
        professor.setNic(professorInputDto.getNic());
        professor.setSex(professorInputDto.getSex());
        professor.setAddress(professorInputDto.getAddress());
        professor.setEmail(professorInputDto.getEmail());
        professor.setPhoneNumber(professorInputDto.getPhoneNumber());
        return professor;
    }
}

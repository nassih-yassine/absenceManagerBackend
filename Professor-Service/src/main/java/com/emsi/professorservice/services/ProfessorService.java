package com.emsi.professorservice.services;

import com.emsi.professorservice.dtos.ProfessorInputDto;
import com.emsi.professorservice.dtos.ProfessorOutputDto;
import com.emsi.professorservice.exceptions.MissingFieldsException;
import com.emsi.professorservice.exceptions.ProfessorIdNotFoundException;
import com.emsi.professorservice.exceptions.ProfessorNICExistException;

import java.util.List;

public interface ProfessorService {
    List<ProfessorOutputDto> allProfessors(); //Get All
    ProfessorOutputDto singleProfessor(String id) throws ProfessorIdNotFoundException; //Get Item By Id
    ProfessorOutputDto createProfessor(ProfessorInputDto professorInputDto) throws MissingFieldsException, ProfessorNICExistException; //Create New Item
    void deleteProfessor(String id) throws ProfessorIdNotFoundException; //Delete Item
    ProfessorOutputDto updateProfessor(String id, ProfessorInputDto professorInputDto) throws MissingFieldsException, ProfessorIdNotFoundException; //Update Item
}

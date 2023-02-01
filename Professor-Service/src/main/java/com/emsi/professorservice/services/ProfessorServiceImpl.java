package com.emsi.professorservice.services;


import com.emsi.professorservice.dtos.ProfessorInputDto;
import com.emsi.professorservice.dtos.ProfessorOutputDto;
import com.emsi.professorservice.entities.Professor;
import com.emsi.professorservice.exceptions.MissingFieldsException;
import com.emsi.professorservice.exceptions.ProfessorIdNotFoundException;
import com.emsi.professorservice.exceptions.ProfessorNICExistException;
import com.emsi.professorservice.mappers.MapperService;
import com.emsi.professorservice.repositories.ProfessorRepository;
import com.emsi.professorservice.utils.ProfessorUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private MapperService mapper;
    private ProfessorRepository repository;
    @Override
    public List<ProfessorOutputDto> allProfessors() {
        return repository.findAll().stream().map(mapper::fromProfessor).toList();
    }

    @Override
    public ProfessorOutputDto singleProfessor(String id) throws ProfessorIdNotFoundException {
        Professor professor = repository.findById(id).orElseThrow(() -> new ProfessorIdNotFoundException(id));
        return mapper.fromProfessor(professor);
    }

    @Override
    public ProfessorOutputDto createProfessor(ProfessorInputDto professorInputDto) throws MissingFieldsException, ProfessorNICExistException {
        if(ProfessorUtils.checkProfessorInputDtoFields(professorInputDto))
            throw new MissingFieldsException();

        Professor professorCheckNIC = repository.findProfessorByNIC(professorInputDto.getNic());
        if( professorCheckNIC != null)
            throw new ProfessorNICExistException(professorInputDto.getNic());

        Professor professor = ProfessorUtils.setProfessorAttribute(professorInputDto, null);
        return mapper.fromProfessor(repository.save(professor));
    }

    @Override
    public void deleteProfessor(String id) throws ProfessorIdNotFoundException {
        Professor professor = repository.findById(id).orElseThrow(() -> new ProfessorIdNotFoundException(id));
        repository.delete(professor);
    }

    @Override
    public ProfessorOutputDto updateProfessor(String id, ProfessorInputDto professorInputDto) throws MissingFieldsException, ProfessorIdNotFoundException {
        if(ProfessorUtils.checkProfessorInputDtoFields(professorInputDto))
            throw new MissingFieldsException();

        repository.findById(id).orElseThrow(() -> new ProfessorIdNotFoundException(id));

        Professor professor = ProfessorUtils.setProfessorAttribute(professorInputDto, id);
        return mapper.fromProfessor(repository.save(professor));
    }
}

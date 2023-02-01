package com.emsi.professorservice.web;

import com.emsi.professorservice.dtos.ProfessorInputDto;
import com.emsi.professorservice.dtos.ProfessorOutputDto;
import com.emsi.professorservice.exceptions.MissingFieldsException;
import com.emsi.professorservice.exceptions.ProfessorIdNotFoundException;
import com.emsi.professorservice.exceptions.ProfessorNICExistException;
import com.emsi.professorservice.services.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProfessorRestController {
    private ProfessorService professorService;

    @GetMapping("/professor-list")
    public List<ProfessorOutputDto> getProfessorList(){return professorService.allProfessors();}

    @GetMapping("/professor/{id}")
    public ProfessorOutputDto getProfessor(@PathVariable String id) throws ProfessorIdNotFoundException {
        return professorService.singleProfessor(id);
    }

    @DeleteMapping("/professor/{id}")
    public void deleteProfessor(@PathVariable String id) throws ProfessorIdNotFoundException {
        professorService.deleteProfessor(id);
    }

    @PostMapping("/professor")
    public ProfessorOutputDto addProfessor(@RequestBody ProfessorInputDto professorInputDto) throws MissingFieldsException, ProfessorNICExistException {
        return  professorService.createProfessor(professorInputDto);
    }

    @PutMapping("/professor/{id}")
    public ProfessorOutputDto updateProfessor(@PathVariable String id, @RequestBody ProfessorInputDto professorInputDto) throws MissingFieldsException, ProfessorIdNotFoundException {
        return professorService.updateProfessor(id, professorInputDto);
    }
}

package com.emsi.professorservice.mappers;

import com.emsi.professorservice.dtos.ProfessorOutputDto;
import com.emsi.professorservice.entities.Professor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public ProfessorOutputDto fromProfessor(Professor professor){
        ProfessorOutputDto professorOutputDto = new ProfessorOutputDto();
        BeanUtils.copyProperties(professor, professorOutputDto);
        return professorOutputDto;
    }
}

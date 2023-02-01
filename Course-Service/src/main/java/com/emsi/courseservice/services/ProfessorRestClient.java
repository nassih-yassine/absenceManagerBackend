package com.emsi.courseservice.services;

import com.emsi.courseservice.models.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name = "PROFESSOR-SERVICE")
public interface ProfessorRestClient {
    @GetMapping(path = "/professor/{id}")
    Professor getProfessor(@PathVariable String id);

    @GetMapping("/professor-list") //TODO: remove after reinitializing data
    Collection<Professor> getAllProfessors();
}

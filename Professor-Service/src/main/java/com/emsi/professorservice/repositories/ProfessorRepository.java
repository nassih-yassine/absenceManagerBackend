package com.emsi.professorservice.repositories;

import com.emsi.professorservice.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
    @Query("select p from Professor p where p.nic = ?1")
    Professor findProfessorByNIC(String nic);
}

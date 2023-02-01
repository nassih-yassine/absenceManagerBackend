package com.emsi.professorservice.exceptions;

public class ProfessorIdNotFoundException extends Exception {
    public ProfessorIdNotFoundException(String id) {
        super("Professor with Id: " + id + ", Not Found!!!!");
    }
}

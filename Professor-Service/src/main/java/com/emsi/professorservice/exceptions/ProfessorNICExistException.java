package com.emsi.professorservice.exceptions;

public class ProfessorNICExistException extends Exception {
    public ProfessorNICExistException(String nic) {
        super("Professor with NIC: " + nic + ", Already Exist!!!!!");
    }
}

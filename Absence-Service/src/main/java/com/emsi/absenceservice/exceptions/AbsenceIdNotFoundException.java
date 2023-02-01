package com.emsi.absenceservice.exceptions;

public class AbsenceIdNotFoundException extends Exception {
    public AbsenceIdNotFoundException(String id) {
        super("Absence with Id: " + id + ", Not Found!!!!!!");
    }
}

package com.emsi.absenceservice.exceptions;

public class StudentIdNotFoundException extends Exception {
    public StudentIdNotFoundException(String studentId) {
        super("Student Id: " + studentId + ", Not Found!!!");
    }
}

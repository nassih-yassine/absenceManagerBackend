package com.emsi.studentservice.exceptions;

public class StudentNICExistException extends Exception {
    public StudentNICExistException(String nic) {
        super("Student with NIC: " + nic + ", Already Exist!!!!!");
    }
}

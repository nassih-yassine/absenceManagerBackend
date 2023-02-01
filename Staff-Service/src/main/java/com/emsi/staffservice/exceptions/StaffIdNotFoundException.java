package com.emsi.staffservice.exceptions;

public class StaffIdNotFoundException extends Exception {
    public StaffIdNotFoundException(String id) {
        super("Staff with ID: "+id+ ", Not Found");
    }
}

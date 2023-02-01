package com.emsi.staffservice.exceptions;

public class StaffNICExistException extends Exception {
    public StaffNICExistException(String nic) {
        super("Staff With National Identity Card Number: " + nic + ", Already Exist!!!!");
    }
}

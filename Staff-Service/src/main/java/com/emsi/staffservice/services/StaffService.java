package com.emsi.staffservice.services;

import com.emsi.staffservice.dtos.StaffInputDto;
import com.emsi.staffservice.dtos.StaffOutputDto;
import com.emsi.staffservice.exceptions.MissingFieldException;
import com.emsi.staffservice.exceptions.StaffIdNotFoundException;
import com.emsi.staffservice.exceptions.StaffNICExistException;

import java.util.List;

public interface StaffService {
    List<StaffOutputDto> allStaff(); //Get All
    StaffOutputDto singleStaff(String id) throws StaffIdNotFoundException; //Get Elem By Id
    StaffOutputDto createStaff(StaffInputDto staffInputDto) throws MissingFieldException, StaffNICExistException; //Create New Elem
    void deleteStaff(String id) throws StaffIdNotFoundException; //Delete Elem By Id
    StaffOutputDto updateStaff(String id, StaffInputDto staffInputDto) throws MissingFieldException, StaffIdNotFoundException; //Update Elem
    //Search Elems By Keyword

}

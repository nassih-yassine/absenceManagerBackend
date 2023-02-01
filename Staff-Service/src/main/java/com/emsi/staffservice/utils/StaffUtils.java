package com.emsi.staffservice.utils;

import com.emsi.staffservice.dtos.StaffInputDto;
import com.emsi.staffservice.entities.Staff;

import java.util.Optional;
import java.util.UUID;

public class StaffUtils {
    public static boolean checkStaffInputDtoFields(StaffInputDto staffInputDto) {
        return staffInputDto.getAddress() == null || staffInputDto.getAddress().isEmpty()
                || staffInputDto.getFirstname() == null || staffInputDto.getFirstname().isEmpty()
                || staffInputDto.getLastname() == null || staffInputDto.getLastname().isEmpty()
                || staffInputDto.getNic() == null || staffInputDto.getNic().isEmpty()
                || staffInputDto.getSex() == null || staffInputDto.getBirthdate() == null
                || staffInputDto.getPhoneNumber() == null || staffInputDto.getPhoneNumber().isEmpty()
                || staffInputDto.getEmail() == null || staffInputDto.getEmail().isEmpty();
    }

    public static Staff setStaffAttribute(StaffInputDto staffInputDto, String id) {
        Staff staff = new Staff();
        Optional<String> staffId = Optional.ofNullable(id);
        if (staffId.isPresent()) {
            staff.setStaffId(id);
        } else {
            staff.setStaffId(UUID.randomUUID().toString());
        }

        staff.setFirstname(staffInputDto.getFirstname());
        staff.setLastname(staffInputDto.getLastname());
        staff.setBirthdate(staffInputDto.getBirthdate());
        staff.setNic(staffInputDto.getNic());
        staff.setSex(staffInputDto.getSex());
        staff.setAddress(staffInputDto.getAddress());
        staff.setEmail(staffInputDto.getEmail());
        staff.setPhoneNumber(staffInputDto.getPhoneNumber());
        return staff;
    }
}

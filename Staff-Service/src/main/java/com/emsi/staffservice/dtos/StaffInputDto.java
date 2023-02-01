package com.emsi.staffservice.dtos;

import com.emsi.staffservice.enums.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class StaffInputDto {
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String nic; //National Identity Card
    private Sex sex;
    private String address;
    private String email;
    private String phoneNumber;
}

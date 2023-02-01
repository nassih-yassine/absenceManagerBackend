package com.emsi.staffservice.dtos;

import com.emsi.staffservice.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffOutputDto {
    private String staffId;
    private String firstname;
    private String lastname;
    private String nic; //National Identity Card
    private Sex sex;
}

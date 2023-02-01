package com.emsi.staffservice.mappers;

import com.emsi.staffservice.dtos.StaffOutputDto;
import com.emsi.staffservice.entities.Staff;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public StaffOutputDto fromStaff(Staff staff){
        StaffOutputDto staffOutputDto = new StaffOutputDto();
        BeanUtils.copyProperties(staff, staffOutputDto);
        return staffOutputDto;
    }
}

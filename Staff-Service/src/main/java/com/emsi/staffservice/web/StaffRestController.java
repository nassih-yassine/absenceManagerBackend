package com.emsi.staffservice.web;

import com.emsi.staffservice.dtos.StaffInputDto;
import com.emsi.staffservice.dtos.StaffOutputDto;
import com.emsi.staffservice.exceptions.MissingFieldException;
import com.emsi.staffservice.exceptions.StaffIdNotFoundException;
import com.emsi.staffservice.exceptions.StaffNICExistException;
import com.emsi.staffservice.services.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StaffRestController {
    private StaffService staffService;

    @GetMapping("/staff-list")
    public List<StaffOutputDto> getStaffList(){
        return staffService.allStaff();
    }

    @GetMapping("/staff/{id}")
    public StaffOutputDto getStaff(@PathVariable String id) throws StaffIdNotFoundException {
        return staffService.singleStaff(id);
    }

    @DeleteMapping("/staff/{id}")
    public void deleteStaff(@PathVariable String id) throws StaffIdNotFoundException {
        staffService.deleteStaff(id);
    }

    @PostMapping("/staff")
    public StaffOutputDto addStaff(@RequestBody StaffInputDto staffInputDto) throws MissingFieldException, StaffNICExistException {
        return staffService.createStaff(staffInputDto);
    }

    @PutMapping("/staff/{id}")
    public StaffOutputDto updateStaff(@PathVariable String id, @RequestBody StaffInputDto staffInputDto) throws MissingFieldException, StaffIdNotFoundException {
        return staffService.updateStaff(id, staffInputDto);
    }
}

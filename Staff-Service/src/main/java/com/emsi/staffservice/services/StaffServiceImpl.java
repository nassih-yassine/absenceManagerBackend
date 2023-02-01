package com.emsi.staffservice.services;

import com.emsi.staffservice.dtos.StaffInputDto;
import com.emsi.staffservice.dtos.StaffOutputDto;
import com.emsi.staffservice.entities.Staff;
import com.emsi.staffservice.exceptions.MissingFieldException;
import com.emsi.staffservice.exceptions.StaffIdNotFoundException;
import com.emsi.staffservice.exceptions.StaffNICExistException;
import com.emsi.staffservice.mappers.MapperService;
import com.emsi.staffservice.repositories.StaffRepository;
import com.emsi.staffservice.utils.StaffUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {
    private StaffRepository repository;
    private MapperService mapper;

    @Override
    public List<StaffOutputDto> allStaff() {
        return repository.findAll().stream().map(mapper::fromStaff).toList();
    }

    @Override
    public StaffOutputDto singleStaff(String id) throws StaffIdNotFoundException {
        Staff staff = repository.findById(id).orElseThrow(() -> new StaffIdNotFoundException(id));
        return mapper.fromStaff(staff);
    }

    @Override
    public StaffOutputDto createStaff(StaffInputDto staffInputDto) throws MissingFieldException, StaffNICExistException {
        if (StaffUtils.checkStaffInputDtoFields(staffInputDto))
            throw new MissingFieldException();

        Staff staffCheckNIC = repository.findStaffByNIC(staffInputDto.getNic());
        if (staffCheckNIC != null)
            throw new StaffNICExistException(staffInputDto.getNic());

        Staff staff = StaffUtils.setStaffAttribute(staffInputDto, null);
        return mapper.fromStaff(repository.save(staff));
    }

    @Override
    public void deleteStaff(String id) throws StaffIdNotFoundException {
        Staff staff = repository.findById(id).orElseThrow(() -> new StaffIdNotFoundException(id));
        repository.delete(staff);
    }

    @Override
    public StaffOutputDto updateStaff(String id, StaffInputDto staffInputDto) throws MissingFieldException, StaffIdNotFoundException {
        if (StaffUtils.checkStaffInputDtoFields(staffInputDto))
            throw new MissingFieldException();

        repository.findById(id).orElseThrow(() -> new StaffIdNotFoundException(id));

        Staff staff = StaffUtils.setStaffAttribute(staffInputDto, id);
        return mapper.fromStaff(repository.save(staff));
    }
}

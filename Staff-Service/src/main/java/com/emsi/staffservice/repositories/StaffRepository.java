package com.emsi.staffservice.repositories;

import com.emsi.staffservice.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<Staff, String> {
    @Query("select s from Staff s where s.nic = ?1 ")
    Staff findStaffByNIC(String nic);
}

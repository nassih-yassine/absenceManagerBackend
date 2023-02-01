package com.emsi.studentservice.repos;


import com.emsi.studentservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepo extends JpaRepository<Student,String> {
    @Query("select s from Student s where s.nic = ?1")
    Student findStudentByNIC(String nic);
}
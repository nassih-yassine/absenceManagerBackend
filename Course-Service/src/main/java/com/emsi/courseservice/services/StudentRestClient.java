package com.emsi.courseservice.services;

import com.emsi.courseservice.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentRestClient {
    @GetMapping(path = "/student/{id}")
    Student getStudent(@PathVariable String id);

    @GetMapping("/students")//TODO: remove after initializing
    Collection<Student> getAll();
}

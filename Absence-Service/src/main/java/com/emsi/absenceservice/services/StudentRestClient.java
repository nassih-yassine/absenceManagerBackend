package com.emsi.absenceservice.services;

import com.emsi.absenceservice.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentRestClient {
    @GetMapping(path = "/student/{id}")
    Student getStudent(@PathVariable String id);
}

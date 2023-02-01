package com.emsi.absenceservice.services;

import com.emsi.absenceservice.models.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseRestClient {
    @GetMapping("/course/simple/{id}")
    Course getCourse(@PathVariable String id);
}

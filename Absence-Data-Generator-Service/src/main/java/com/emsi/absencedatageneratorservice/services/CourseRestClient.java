package com.emsi.absencedatageneratorservice.services;

import com.emsi.absencedatageneratorservice.models.CourseDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseRestClient {
    @GetMapping("/courses/details")
    Collection<CourseDetails> getAllCoursesDetails();
}

package com.emsi.dataanalyticsservice.services;

import com.emsi.dataanalyticsservice.models.AbsenceListPerCourse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient("ABSENCE-SERVICE")
public interface AbsenceRestClient {
    @GetMapping("/absence/course/{courseId}")
    Collection<AbsenceListPerCourse> getAbsencePerCourse(@PathVariable String courseId);
}

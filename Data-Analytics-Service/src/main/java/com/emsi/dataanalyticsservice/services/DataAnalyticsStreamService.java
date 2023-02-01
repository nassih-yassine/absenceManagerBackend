package com.emsi.dataanalyticsservice.services;

import com.emsi.dataanalyticsservice.models.AbsenceInput;
import com.emsi.dataanalyticsservice.models.AbsenceListPerCourse;
import com.emsi.dataanalyticsservice.models.AbsenceOutput;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class DataAnalyticsStreamService {
    private AbsenceRestClient absenceRestClient;
    @Bean
    public Function<AbsenceInput, AbsenceOutput> absenceDataStreamProcessing(){
        return (input)->{
            AbsenceOutput absenceOutput = new AbsenceOutput();
            Collection<AbsenceListPerCourse> absences = absenceRestClient.getAbsencePerCourse(input.getCourseId());
            absenceOutput.setCourseId(input.getCourseId());
            absenceOutput.setAbsenceLiveNumber(absences.size());
            return absenceOutput;
        };
    }
}

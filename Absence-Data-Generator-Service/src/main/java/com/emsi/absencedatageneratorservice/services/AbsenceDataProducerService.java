package com.emsi.absencedatageneratorservice.services;

import com.emsi.absencedatageneratorservice.models.Absence;
import com.emsi.absencedatageneratorservice.models.CourseDetails;
import com.emsi.absencedatageneratorservice.models.Students;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class AbsenceDataProducerService {
    private CourseRestClient courseRestClient;
    @Bean
    public Supplier<Absence> absenceDataSupplier(){
        return () -> {
            int randomSleepTime = (int) (Math.random() * 10000);
            try {
                Thread.sleep(randomSleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Collection<CourseDetails> courses = courseRestClient.getAllCoursesDetails();
            Random random = new Random();
            int i = random.nextInt(courses.size());
            CourseDetails course = (CourseDetails) courses.toArray()[i];
            Absence a = new Absence();
            a.setCourseId(course.getCourseId());
            int j = random.nextInt(course.getStudents().size());
            Students students = (Students) course.getStudents().toArray()[j];
            a.setStudentId(students.getStudent().getStudentId());
            return a;
        };
    }
}

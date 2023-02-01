package com.emsi.absenceservice.web;

import com.emsi.absenceservice.dtos.AbsenceInputDto;
import com.emsi.absenceservice.dtos.AbsenceOutputDto;
import com.emsi.absenceservice.services.AbsenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class AbsenceRestController {
    private AbsenceService absenceService;

    @PostMapping("/absence")
    public AbsenceOutputDto createAbsence(@RequestBody AbsenceInputDto absenceInputDto) throws Exception {
        return absenceService.addAbsence(absenceInputDto);
    }

    @GetMapping("/absences")
    public Collection<AbsenceOutputDto> absenceList(){
        return absenceService.getAll();
    }

    @GetMapping("/absence/{id}")
    public AbsenceOutputDto getAbsence(@PathVariable String id) throws Exception {
        return absenceService.getSingle(id);
    }

    @GetMapping("/absence/student/{studentId}")
    public Collection<AbsenceOutputDto> getStudentAbsence(@PathVariable String studentId) throws Exception {
        return absenceService.getStudentAbsence(studentId);
    }

    @GetMapping("/absence/course/{courseId}")
    public Collection<AbsenceOutputDto> getCourseAbsence(@PathVariable String courseId) throws Exception {
        return absenceService.getCourseAbsence(courseId);
    }

    @DeleteMapping("/absence/{id}")
    public void deleteAbsence(@PathVariable String id) throws Exception {
        absenceService.deleteAbsence(id);
    }
}
